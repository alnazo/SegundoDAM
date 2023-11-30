using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataGridBinding.dto
{
    public class Cita : INotifyPropertyChanged
    {

        public String Nombre { get; set; }
        public String Apellidos { get; set; }
        public String Grupo { get; set; }
        public DateTime Fecha { get; set; }
        public String Ciudad { get; set; }
        public String Sala { get; set; }

        public Cita()
        {
            Grupo = "Si";
            Fecha = DateTime.Now;
            Sala = "Sala 1";
        }

        public Cita(string nombre, string apellidos, string grupo, DateTime fecha, string ciudad, string sala)
        {
            Nombre = nombre;
            Apellidos = apellidos;
            Grupo = grupo;
            Fecha = fecha;
            Ciudad = ciudad;
            Sala = sala;
        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
}
