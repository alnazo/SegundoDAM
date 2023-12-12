using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BindingyClases
{
    public class jugadores
    {
        public string nombre { get; set; }
        public string apellido { get; set; }

        public jugadores(string nombre, string apellido)
        {
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public override string ToString()
        {
            return nombre + " " + apellido;
        }
    }
}
