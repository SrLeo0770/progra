<%-- 
    Document   : userDashboard
    Created on : 23 oct 2024, 4:17:19 p.m.
    Author     : Lester
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">User Dashboard</h1>
        <p class="text-center">Bienvenido, <%= session.getAttribute("userName") %></p>

        <div class="row justify-content-center mt-4">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Perfil de Usuario</h5>
                        <p class="card-text">Accede a tu información personal y ajusta las configuraciones de la cuenta.</p>
                        <a href="#" class="btn btn-primary">Ver Perfil</a>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="text-center mt-4">
            <a href="LogoutServlet" class="btn btn-danger">Cerrar sesión</a>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

