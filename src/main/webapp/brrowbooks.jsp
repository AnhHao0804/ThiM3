<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/09/2024
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mượn Sách</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .form-group {
            margin-bottom: 1.5rem;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center mb-4">Mượn Sách</h1>
    <form id="borrowForm" action="submit_borrow" method="post">
        <div class="form-group">
            <label for="borrowId">Mã Mượn Sách</label>
            <input type="text" class="form-control" id="borrowId" name="borrowId" placeholder="ms-xxxx" pattern="ms-\d{4}" required>
        </div>
        <div class="form-group">
            <label for="bookName">Tên Sách</label>
            <select class="form-control" id="bookName" name="bookName" required>
            </select>
        </div>
        <div class="form-group">
            <label for="studentName">Tên Học Sinh</label>
            <select class="form-control" id="studentName" name="studentName" required>
            </select>
        </div>
        <div class="form-group">
            <label for="borrowDate">Ngày Mượn</label>
            <input type="text" class="form-control" id="borrowDate" name="borrowDate" readonly>
        </div>
        <div class="form-group">
            <label for="returnDate">Ngày Trả</label>
            <input type="date" class="form-control" id="returnDate" name="returnDate" min="" required>
            <small class="form-text text-muted">Ngày trả không được phép trước ngày mượn.</small>
        </div>
        <button type="submit" class="btn btn-primary" id="borrowButton">Mượn Sách</button>
        <button type="button" class="btn btn-secondary" id="cancelButton">Hủy</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
