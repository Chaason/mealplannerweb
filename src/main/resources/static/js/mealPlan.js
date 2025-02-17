async function generateMealPlan() {
    try {
        const response = await fetch('/api/recipes/random', {method: 'GET',
            /*headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})*/
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