/**
  * Created by osboxes on 25/03/17.
  */
object kik {
  var Plansza = Array("1","2","3","4","5","6","7","8","9")
  var znaki = Array("X","O")
  var ilosc_odczytow: Int = 0

  def main(args: Array[String]): Unit = {

    var koniec: Int = 0
    while (koniec == 0)
    {
      rysuj_kwadrat()
      wczytaj_znak(1)
      koniec = sprawdz_gracza(1)
      if(koniec == 0) {
        rysuj_kwadrat()
        wczytaj_znak(2)
        koniec = sprawdz_gracza(2)
      }
    }

    if (koniec < 0) println("\nRemis"+" :" )
    else println("\nWygral gracz " + koniec+" :" )
    rysuj_kwadrat()
  }

  def rysuj_kwadrat(): Unit ={

   var i: Int = 0
    //i = 0
    while(i < 9)
      {
        println("| " + Plansza(i) + " | " + Plansza(i+1) + " | " + Plansza(i+2) + " |")
        i = i+3;
      }
}

def wczytaj_znak(nr_gracza:Int): Unit = {

  ilosc_odczytow+=1
  if (ilosc_odczytow > 9) return

  var znak: String = "0"
  var nr_pola: Int = 0
  while(znak == "0") {
    znak = scala.io.StdIn.readLine("Gracz: " + nr_gracza + " podaj numer pola: ")
    var blad: String = ""
    if(znak < "1" || znak > "9") {
      blad = "Bledny numer pola"
    }
    if(blad == ""){
      nr_pola = Integer.parseInt(znak)
      if(Plansza(nr_pola-1)=="X" || Plansza(nr_pola-1)=="O")
        {
          blad = "Ten numer pola jest juz zajety"
        }
      else
        {
          Plansza(nr_pola-1) = znaki(nr_gracza-1)
        }
    }
    if(blad == "") return
    znak = "0"
    println(blad)
  }
}

def sprawdz_gracza(nr_gracza:Int): Int =
{
  if (ilosc_odczytow > 9) return -1

  var i:Int=0
  while(i < 9) {
    if(Plansza(i) == znaki(nr_gracza-1) && Plansza(i+1) == znaki(nr_gracza-1) && Plansza(i+2) == znaki(nr_gracza-1))  return nr_gracza
    i=i+3
  }
  i=0
  while(i < 3) {
    if(Plansza(i) == znaki(nr_gracza-1) && Plansza(i+3) == znaki(nr_gracza-1) && Plansza(i+6) == znaki(nr_gracza-1))  return nr_gracza
    i=i+1
  }
  if(Plansza(0) == znaki(nr_gracza-1) && Plansza(4) == znaki(nr_gracza-1) && Plansza(8) == znaki(nr_gracza-1))  return nr_gracza
  if(Plansza(2) == znaki(nr_gracza-1) && Plansza(4) == znaki(nr_gracza-1) && Plansza(6) == znaki(nr_gracza-1))  return nr_gracza
  return 0
}
}



