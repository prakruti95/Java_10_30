<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charse	t="UTF-8">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f7fa;
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.login-card{
    width:400px;
    padding:40px;
    border-radius:15px;
    background:white;
    box-shadow:0 0 20px rgba(0,0,0,0.1);
}

.store-title{
    text-align:center;
    margin-bottom:30px;
    font-weight:bold;
    color:#0d6efd;
}

</style>

</head>

<body>

<div class="login-card">

    <h2 class="store-title">
        Mobile Inventory Login
    </h2>

    <form action="/loginCheck" method="post">

        <div class="mb-3">
            <label>Username</label>

            <input type="text"
                   name="username"
                   class="form-control"
                   required>
        </div>

        <div class="mb-3">
            <label>Password</label>

            <input type="password"
                   name="password"
                   class="form-control"
                   required>
        </div>

        <div class="text-danger mb-3">
            ${msg}
        </div>

        <button class="btn btn-primary w-100">
            Login
        </button>

    </form>

</div>

</body>
</html>