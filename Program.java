class Punkt
{
   double x;
   double y;
 
   Punkt(double x,double y) 
   {                        
      this.x=x;             
      this.y=y;             
   }                        
 
   public String toString()          
   {                                 
      return "[x: "+x+", y: "+y+"]"; 
   }
 
   void przesun(double dx, double dy)
   {
      this.x=x+dx;
      this.y=y+dy;
   }
                                 
}

class Prostokat
{
   double dlugosc;
   double szerokosc;
   Punkt wierzcholek;
 
   Prostokat()            
   {                      
      this.dlugosc=0.0;   
      this.szerokosc=0.0;
      this.wierzcholek=new Punkt(0,0); 
   }                      
 
   Prostokat(double dlugosc,double szerokosc, Punkt wierzcholek)  
   {                                          
      this.dlugosc=dlugosc;                   
      this.szerokosc=szerokosc;
      this.wierzcholek=wierzcholek;               
   }                                          
 
   public String toString()
   {
      return "[dl: "+dlugosc+", sz: "+szerokosc+"]" + wierzcholek.toString();
   }
   double pole()                
   {                            
      return dlugosc*szerokosc; 
   }

   double obwod()
   {
      return 2*dlugosc+2*szerokosc;
   }
   void przesun(double u, double v)
   {
      this.wierzcholek.przesun(u,v);   
   }
   boolean zawiera(Punkt obj) 
   {
      return ((this.wierzcholek.x<=obj.x)&&(this.wierzcholek.x+this.dlugosc>=obj.x))&&((this.wierzcholek.y<=obj.y)&&(this.wierzcholek.y+this.szerokosc>=obj.y));
   }
   boolean przecina(Okrag obj)
   {
      return ((this.wierzcholek.x<=obj.srodek.x+promien)&&(this.wierzcholek.x+this.dlugosc>=obj.srodek.x+promien))&&((this.wierzcholek.y<=obj.srodek.y+promien)&&(this.wierzcholek.y+this.szerokosc>=obj.srodek.y+promien));
   }
}

class Okrag
{
   double promien;
   Punkt srodek;
   
   Okrag()
   {
   this.promien=0.0;
   this.srodek=new Punkt(0,0);
   }
   Okrag(double promien, Punkt srodek)
   {
      this.promien=promien;
      this.srodek=srodek;
   }
   public String toString()
   {
      return "[r: "+promien+"]" + srodek.toString();
   }
   double pole()
   {
      return Math.PI * promien*promien;
   }
   double obwod()
   {
      return Math.PI * promien *2;
   }
   void przesun(double u, double v)
   {
      this.srodek.przesun(u,v); 
   }
   boolean zawiera(Punkt obj)
   {
      return Math.pow((Math.pow((obj.x-this.srodek.x),2)+Math.pow((obj.y-this.srodek.y),2)),0.5)<=this.promien;
   } 
   boolean przecina(Okrag obj)
   {
      return Math.abs(this.promien-obj.promien)<Math.pow((Math.pow((obj.srodek.x-this.srodek.x),2)+Math.pow((obj.srodek.y-this.srodek.y),2)),0.5)&&Math.pow((Math.pow((obj.srodek.x-this.srodek.x),2)+Math.pow((obj.srodek.y-this.srodek.y),2)),0.5)<(this.promien-obj.promien);
   }
}
public class Program
{
   public static void main(String[] args)         
   {                                             
/*      Prostokat obj;                             
      obj=new Prostokat(3,4);                    
      double x=obj.pole();
      double y=obj.obwod();                       
 
      System.out.println("Pole prostokata: "+x);
      System.out.println("Obwod prostokata: "+y);*/

      Punkt obj;
      obj = new Punkt(0,0);
      System.out.println("punkt: "+obj);
 
 /*     obj.przesun(-1,3);
      System.out.println(obj);*/

      Punkt obj1;                             
      obj1=new Punkt(-1,1);                   
      System.out.println("punkt: "+obj1);     

      Punkt obj3;                             
      obj3=new Punkt(5,5);                   
      System.out.println("punkt: "+obj3);  
 
      Okrag obj2;                         
      obj2=new Okrag(4,obj);           
      System.out.println("prostokat: "+obj2);
      
/*      obj2.przesun(7,-3);
      System.out.println(obj2);
 
      double p=obj2.pole();                   
      System.out.println("pole: "+p);
      Okrag obj5;
      obj5=new Okrag(5,obj);
      double r=obj5.pole();                   
      System.out.println("pole: "+r);*/
      
      boolean x1=obj2.przecina(obj2);
      System.out.println("zawiera "+obj2+x1);
   }                                             
}
