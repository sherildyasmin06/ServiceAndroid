using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

[WebService(Namespace = "http://microsoft.com/webservices/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]

public class Service : System.Web.Services.WebService
{
    public Service () {
        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }
    //Generando un metodo web de suma de numeros 
    [WebMethod]
    public int Sumatoria(int x1,int x2,int x3)
    {
        return (x1 + x2 + x3);
    }
  //Generando un metodo webde factorial de un numero
    [WebMethod]
    public double Factorial(int vnumero)
    {
        double xfactorial=1;
        for (int i = 1; i <= vnumero; i++) 
        {
            //Calculando el factorial
            xfactorial *= i;
        }
        //Imprimiendo el resultado de un factorial de un numero
        return xfactorial;
    }
    //Generando el metodo webdel area de un triangulo 
    [WebMethod]
    public double Triangulo(int vbase,int altura){
    return((vbase*altura)/2);
}
}