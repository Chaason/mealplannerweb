async function generateMealPlan() {
    const selectedCategories = [];
    if (document.getElementById('meat').checked) selectedCategories.push('肉系');
    if (document.getElementById('fish').checked) selectedCategories.push('魚系');
    if (document.getElementById('vegetable').checked) selectedCategories.push('野菜系');

    try {
        const response = await fetch('/api/recipes/random', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(selectedCategories)
        });

        if (!response.ok) throw new Error('献立の生成に失敗しました');

        const recipes = await response.json();

        const mealResults = document.getElementById('meal-results');
        mealResults.innerHTML = '';
        recipes.forEach(recipe => {
            const recipeDiv = document.createElement('div');
            const recipeLink = document.createElement('a');
            recipeLink.href = recipe.url;
            recipeLink.innerText = recipe.name;
            recipeLink.target = '_blank';
            recipeDiv.appendChild(recipeLink);
            mealResults.appendChild(recipeDiv);
        });
    } catch (error) {
        alert(error.message);
    }
}

