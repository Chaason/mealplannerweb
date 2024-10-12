async function register() {
    const username = document.getElementById('new-username').value;
    const password = document.getElementById('new-password').value;
    try {
        const response = await fetch(`/api/users/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username: username, password: password })
        });

        if (!response.ok) throw new Error('登録に失敗しました');

        alert('登録が成功しました。ログイン画面に戻ります。');
        window.location.href = 'login.html'; // ログインページにリダイレクト
    } catch (error) {
        alert(error.message);
    }
}
