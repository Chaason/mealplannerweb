async function generateMealPlan() {
    const selectedIngredients = [];
    document.querySelectorAll('#meal-plan input[type="checkbox"]:checked').forEach(checkbox => {
        selectedIngredients.push(checkbox.value);
    });

    const username = document.getElementById('username').value;
    try {
        const response = await fetch('/api/recipes/random', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: username,
                ingredients: selectedIngredients
            })
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

            recipe.user = { id: userId }; // ユーザー情報を追加
        });

        // 保存用にグローバル変数に保存
        window.currentRecipes = recipes;
    } catch (error) {
        alert(error.message);
    }
}

async function saveMealPlan() {
    if (!window.currentRecipes) return alert('まずは献立を生成してください');

    try {
        const response = await fetch('/api/recipes/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(window.currentRecipes)
        });

        if (!response.ok) throw new Error('献立の保存に失敗しました');

        alert('献立が保存されました');
    } catch (error) {
        alert(error.message);
    }
}
