<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加猫咪</title>
    <!-- 引入 Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="container">

    <div class="page-header">
        <h1>添加猫咪</h1>
    </div>

    <form action="AddCatServlet" method="post" enctype="multipart/form-data" class="form-horizontal">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名字：</label>
            <div class="col-sm-10">
                <input type="text" id="name" name="name" class="form-control" placeholder="猫咪的名字" required>
            </div>
        </div>

        <div class="form-group">
            <label for="breed" class="col-sm-2 control-label">品种：</label>
            <div class="col-sm-10">
                <input type="text" id="breed" name="breed" class="form-control" placeholder="猫咪的品种" required>
            </div>
        </div>

        <div class="form-group">
            <label for="sex" class="col-sm-2 control-label">性别：</label>
            <div class="col-sm-10">
                <label class="radio-inline"><input type="radio" name="sex" value="公" required>公</label>
                <label class="radio-inline"><input type="radio" name="sex" value="母">母</label>
            </div>
        </div>

        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">年龄：</label>
            <div class="col-sm-10">
                <input type="number" id="age" name="age" class="form-control" placeholder="猫咪的年龄（岁）" max="20" min="0" required>
            </div>
        </div>

        <div class="form-group">
            <label for="character" class="col-sm-2 control-label">性格：</label>
            <div class="col-sm-10">
                <select id="character" name="character" class="form-control" required>
                    <option value="">请选择</option>
                    <option value="温顺">温顺</option>
                     <option value="乖巧">乖巧</option>
                    <option value="独立">独立</option>
                    <option value="活泼">活泼</option>
                    <option value="胆小">胆小</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">地址：</label>
            <div class="col-sm-10">
                <input type="text" id="address" name="address" class="form-control" placeholder="猫咪的出没地址" required>
            </div>
        </div>

        <div class="form-group">
            <label for="avatar" class="col-sm-2 control-label">头像：</label>
            <div class="col-sm-10">
                <input type="file" id="catnum" name="catnum" accept="image/*" required>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">提交</button>
                <button type="reset" class="btn btn-default">重置</button>
            </div>
        </div>
    </form>

</div>

</body>
</html>