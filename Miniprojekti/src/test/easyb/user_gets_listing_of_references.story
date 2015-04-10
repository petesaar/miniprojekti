import miniprojekti.*

description 'User get a listing of references'

scenario "creation succesfull with correct username and password", {
    given 'command new user is selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("Volter Kilpi", "Alastalon salissa", 1933 )
       io2 = new StubIO("Aleksis Kivi", "Seitsemän veljestä", 1870)
       app = new App(io, auth)
    }
 
    when 'a valid username and password are entered', {
      app.app()
    }

    then 'new user is registered to system', {
      io.getPrints().shouldHave("new user registered")
      io2.getPrints().shouldHave("new user registered")
    }
}

