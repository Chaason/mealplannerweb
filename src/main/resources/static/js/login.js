async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    try {
        const response = await fetch(`/api/users/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username: username, password: password })
        });

        if (!response.ok) throw new Error('ログインに失敗しました');

        const user = await response.json();
        sessionStorage.setItem('userId', user.id); // ユーザーIDをセッションに保存
        window.location.href = 'main.html'; // メインページにリダイレクト
    } catch (error) {
        alert(error.message);
    }
}

function redirectToRegister() {
    window.location.href = 'register.html'; // 新規登録ページにリダイレクト
}
