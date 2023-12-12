using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataGridBinding.dto
{
    public class Cita : INotifyPropertyChanged, IDataErrorInfo
    {

        public String Nombre { get; set; }
        public String Apellidos { get; set; }
        public String Grupo { get; set; }
        public DateTime Fecha { get; set; }
        public String Ciudad { get; set; }
        public String Sala { get; set; }

        public string this[string columnName]
        {
            get
            {
                string result = "";

                if (columnName == "Nombre")
                {
                    if (string.IsNullOrEmpty(Nombre))
                    {
                        result = "Debe introducir un nombre";
                    }
                }
                if (columnName == "Apellidos")
                {
                    if (string.IsNullOrEmpty(Apellidos))
                    {
                        result = "Debe introducir un apellido";
                    }
                }
                if (columnName == "Ciudad")
                {
                    if (string.IsNullOrEmpty(Ciudad))
                    {
                        result = "Debe introducir una ciudad";
                    }
                }
                    return result;
            }
        }

        public string Error => throw new NotImplementedException();

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
