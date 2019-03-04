
 /**
 * Esta clase representa estructuras de tipo
 * cuenta bancaria.
 *
 * Cada objeto de esta clase contendrá las
 * siguientes variables:
 *	- Código de cuenta (tipo entero)
 * 	- Nombre del titular (tipo String)
 *	- Cantidad DEBE (tipo entero)
 *	- Cantidad HABER (tipo entero)
 *	- Cuenta siguiente (tipo CuentaSB)
 *
 * Los métodos soportados por esta clase son:
 *   * Constructores
 *	- CuentaSB (codigo,titular)
 *   * Acceso a campos
 *	- Titular
 *	- Saldo
 *   * Operaciones sobre la cuenta
 *	- Busqueda
 *		por Código
 *		por Titular
 *	- Reintegro
 *	- Imposicion
 *
 *  
 */

class CuentaSB {  
   private int    	codigoCuenta;
   private String 	titularCuenta;
   private int    	saldo;
   private CuentaSB 	siguienteCuenta;

   private static CuentaSB cuentaInicial = null;

      /** Constructor básico          *
        *  - Requiere necesariamente  *
	    *    codigo                   *
        *    titular                  */
   public CuentaSB(int codigo, 
		   String titular) {
      codigoCuenta  	= codigo;
      titularCuenta 	= titular;
      siguienteCuenta 	= null;
      if (cuentaInicial == null)
         cuentaInicial = this;
      else {
         CuentaSB cuentaAux = cuentaInicial;
         while (cuentaAux.siguienteCuenta != null)
            cuentaAux = cuentaAux.siguienteCuenta;
         cuentaAux.siguienteCuenta = this;
      }
   }

      /** Funciones de acceso a los   *
        * campos privados de la clase */ 

      /** Devuelve el valor del debe  */
   public String Titular () {
      return titularCuenta;
   }



      /** Devuelve el saldo */
   public int getSaldo () {
      return saldo;
   }

      /** Método toString para la     *
        * impresión del contenido de  *
	    * de una cuenta               */
   public String toString() {
      String imprime = "   #>CUENTA: " + 
			codigoCuenta;
      imprime += "\n\tTitular : " + Titular();
      imprime += "\n\tSaldo   : " + getSaldo();
      return imprime;
   }

      /* Método Suma */
   public boolean suma(int cantidad) {
	saldo += cantidad;
	return true;
   }

      /* Método Reintegro */
   public boolean Reintegro(int cantidad) {
	if (getSaldo() >= cantidad) {
		saldo -= cantidad;
		return true;
	} else
		return false;
   }

      /* Método BuscaCuenta por codigo*/
   public static CuentaSB buscaCuentaSB(int codigo) {
	CuentaSB cuentaAux = cuentaInicial;

	while (cuentaAux != null) {
		if (cuentaAux.codigoCuenta == codigo)
			return cuentaAux;
		else
			cuentaAux = cuentaAux.siguienteCuenta;
	}

	return null;
   }

   public static void listadoCuentasSB() {
	CuentaSB cuentaAux = cuentaInicial;

	System.out.println("LISTADO DE CUENTAS");
	while (cuentaAux != null) {
                System.out.println(cuentaAux);
		cuentaAux = cuentaAux.siguienteCuenta;
	}
   }


}


/******** Fin de CuentaSB.java ***************/
