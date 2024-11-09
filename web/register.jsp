<%-- 
    Document   : register
    Created on : 23 oct 2024, 4:16:49 p.m.
    Author     : Lester
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .register-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        .btn-primary {
            background-color: #6f42c1;
            border-color: #6f42c1;
        }
        .btn-primary:hover {
            background-color: #5a34a0;
            border-color: #5a34a0;
        }
        .form-label {
            color: #6f42c1;
        }
    </style>
</head>
<body>

<div class="register-container">
    <h2 class="text-center text-primary">Register</h2>
    <form action="RegisterServlet" method="post">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre Completo</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="mb-3">
            <label for="correo" class="form-label">Correo</label>
            <input type="email" class="form-control" id="correo" name="correo" required>
        </div>
        <div class="mb-3">
            <label for="telefono" class="form-label">Telefono</label>
            <input type="text" class="form-control" id="telefono" name="telefono" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Contraseña</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="mb-3">
            <label for="roll" class="form-label">Roll</label>
            <select class="form-control" id="roll" name="roll" required>
                <option value="user">Usuario</option>
                <option value="admin">Administrador</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary w-100">Register</button>
    </form>
    <div class="mt-3 text-center">
        <p>¿Ya tienes una cuenta? <a href="login.jsp">Ingresar</a></p>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>



