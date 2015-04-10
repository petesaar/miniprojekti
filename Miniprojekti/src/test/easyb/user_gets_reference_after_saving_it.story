import miniprojekti.*

description 'User gets reference printed to screen after adding it"

scenario "user adds a reference correctly", {
    given 'Book author, title and year are inserted', {
       io = new StubIO("Aleksis Kivi", "Seitsemän veljestä", 1870)
       app = new App()
    }

    when 'tag field is empty', {
       app.app()
    }

    then 'reference is printed to screen', {
       io.getPrints().shouldHave("Aleksis Kivi")
       io.getPrints().shouldHave("Seitsemän veljestä")
       io.getPrints().shouldHave("1870")
    }
}