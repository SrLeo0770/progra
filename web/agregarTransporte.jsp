
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Orden</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Agregar Orden</h1>
        
        <form action="RegistrarTransporte" method="post" class="mt-4">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre del cliente </label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="mb-3">
                <label for="direccion" class="form-label">Numero de orden</label>
                <input type="text" class="form-control" id="contacto" name="contacto" required>
            </div>
            <div class="mb-3">
                <label for="direccion" class="form-label">Telefono</label>
                <input type="text" class="form-control" id="telefono" name="telefono" required>
            </div>
            <div class="mb-3">
                <label for="direccion" class="form-label">Correo</label>
                <input type="email" class="form-control" id="correo" name="correo" required>
            </div>
            <button type="submit" class="btn btn-primary">Agregar Orden</button>
        </form>
        
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>