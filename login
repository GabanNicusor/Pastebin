<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PasteBin</title>
    <link rel = "stylesheet" href = "designPages.CSS">
</head>
<body>
  <div class="form">
    <form>
      <h2> Register </h2>
      <div class="input-box">
        <i class="fa fa-user" aria-hidden="true"></i>
        <input type="text" name="Username" placeholder="Username" required>
      </div>
      <div class="input-box">
        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
        <input type="password" name="password" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
      </div>
      <div class="input-box">
        <input type="submit" name="sign-in" value="Register">
      </div>
      <a href="/login">Go to Login Page</a>
    </form>
  </div>
</body>
</html>