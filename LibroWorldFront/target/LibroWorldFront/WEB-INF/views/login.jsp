 <style>
     .container {
              margin-top: 2%;
              border:2px solid rgb(88,17,67);
              background-color: rgba(206, 193, 201, 0.5);
              margin-bottom: 2%;
              padding:1%;
              width:30%;
              height:85%;
              
     }
     
.form-label-group {
 
  display: flex;
  width: 100%;
  margin-top: 12%;
}

.icon {
  padding: 9px;
  background: rgb(255, 253, 253);
  color: rgb(19, 3, 15);
  min-width: 50px;
  border:1px solid rgb(19, 1, 13);
  text-align: center;
}
       body{
           background-image: url(img/bge2.jpg);           
       }
            div {
                color: rgb(10, 9, 9);
                }
                .btn
                  {
            background-color: rgb(170, 27, 170);
                    }
                    img{
                        margin-top: 2%;
                        margin-left: 4%;
                    }
        input[type=text]{
            border: 1px solid rgb(88, 17, 67);
            border-radius: 0%;
}
hr.new1 {
  border-top: 2px solid rgb(88, 17, 67);
}
    ul
    {
        display: flex;
        flex-wrap: wrap;
        justify-content:center;
        align-items: center;
        color:rgb(12, 1, 9);
    }
    li
    {
        padding-left: 5%;
        font-size: xx-large;
        list-style-type:none;
       
    }
    .fa{
      color:rgb(88, 17, 67);
    }
    .pencil{
      display: flex;
        flex-wrap: wrap;
        justify-content:center;
        align-items: center;
    }

    }
            </style>
    <body>
            
                <div class="container">
                <div class="col-12" style="margin-top:5%">
                <h2 class="text-center">Sign in<i class="fa fa-pencil fa-lg" id="pencil"></i></h2>
            <div>  
                <form>

                    <div class="form-label-group">
                      <label for="inputEmail"></label>
                      <i class="fa fa-user icon"></i>
                        <input type="text" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                       
                      </div>
      
                      <div class="form-label-group">
                        <label for="inputPassword"></label>
                        <i class="fa fa-key icon"></i>
                        <input type="text" id="inputPassword" class="form-control" placeholder="Password" required autofocus>
                       
                      </div>
      
                      <div class="custom-control custom-checkbox mb-3">
                        <input type="text" class="custom-control-input" id="customCheck1">
                        <label class="custom-control-label" for="customCheck1">Remember password</label>
                      </div>
                      <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Sign in</button>
                      <div class="text-center">
                        <a class="small" style="color:black" href="#">Forgot password?</a></div>
                        <hr class="new1">
                        <p style="text-align:center"> LOGIN HERE|NEW OFFERS AVAILABLE!</p>
                         <p style="text-align:center"> Lower levels of Stress and Tension Relief</p>
                        
                        <div class="footer-social-icons">
                              <ul class="text-center">
                              <li><a href="#" target="blank"><i class="fa fa-google" aria-hidden="true"></i></a></li>
                              <li><a href="#" target="blank"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>    
                              <li><a href="#" target="blank"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                              <li><a href="#" target="blank"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                              
                              </ul>
                        </div>
                </form>
                </div>
            
            </div>
         </div>