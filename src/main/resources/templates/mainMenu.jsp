<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>MainMenu</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

<div class="container">
  <div class="row justify-content-center mt-5">
    <div class="col-md-6">
      <div class="header">
        <h2 class="text-center mb-4">Tela Principal</h2>
        <div class="d-flex justify-content-between align-items-center mb-4">
          <a href="index.jsp" class="btn btn-danger">Sair</a>
        </div>
      </div>
      <div class="content">
        <div class="text-center">
          <form action="MovieController">
            <input type="hidden" name="acao" value="listMovie"></input
            <input type="hidden" name="id" value=${user.id}></input
            <button type="submit" class="btn btn-primary">Filmes</button>
          </form>
          <form action="BookController">
            <input type="hidden" name="acao" value="listBook"></input
            <button type="submit" class="btn btn-primary">Livros</button>
          </form>
          <form action="CartoonController">
            <input type="hidden" value="listCartoon"></input
            <button type="submit" class="btn btn-primary">Cartoons</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="script.js"></script>
</body>
</html>
