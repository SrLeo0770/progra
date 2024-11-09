
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Admin Dashboard</h1>
        <p class="text-center">Bienvenido, <%= session.getAttribute("userName") %> (Administrador)</p>


     
        
        <div class="row justify-content-center mt-4">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Gestión de Ordenes</h5>
                        <a href="agregarTransporte.jsp" class="btn btn-primary">Agregar Orden</a>
                      <a href="MostrarOrden.jsp" class="btn btn-primary">Mostrar Orden</a>
                    </div>
            
                 
        <div class="text-center mt-4">
            <a href="LogoutServlet" class="btn btn-danger">Cerrar sesión</a>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


