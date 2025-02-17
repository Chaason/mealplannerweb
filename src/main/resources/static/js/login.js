async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    try {
        const response = await fetch(`/api/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username: username, password: password })
        });

        if (!response.ok) throw new Error('ログインに失敗しました');

        window.location.href = 'main.html'; // メインページにリダイレクト
    } catch (error) {
        alert(error.message);
    }
}