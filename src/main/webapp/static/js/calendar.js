document.addEventListener('DOMContentLoaded', () => {
    const userId = sessionStorage.getItem('userId');
    if (userId) {
        loadUserRecipes(userId);
    } else {
        alert('ログインしてください');
        window.location.href = 'login.html';
    }
});

async function loadUserRecipes(userId) {
    const response = await fetch(`/api/recipes/user/${userId}`);
    const recipes = await response.json();

    const calendar = document.getElementById('calendar');
    calendar.innerHTML = ''; // カレンダーをクリア

    const today = new Date();
    const startOfWeek = new Date(today.setDate(today.getDate() - today.getDay())); // 日曜日

    const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

    for (let i = 0; i < 7; i++) {
        const day = new Date(startOfWeek);
        day.setDate(startOfWeek.getDate() + i);

        const dayDiv = document.createElement('div');
        dayDiv.className = 'day';
        dayDiv.innerText = `${days[day.getDay()]} ${day.getMonth() + 1}/${day.getDate()}`;

        // 献立を表示
        const recipe = recipes[i % recipes.length];
        const recipeLink = document.createElement('a');
        recipeLink.href = recipe.url;
        recipeLink.innerText = recipe.name;
        recipeLink.target = '_blank';
        dayDiv.appendChild(document.createElement('br'));
        dayDiv.appendChild(recipeLink);

        calendar.appendChild(dayDiv);
    }
}
