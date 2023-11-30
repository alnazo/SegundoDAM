using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataGridBinding.dto
{
    public class Logica
    {

        public ObservableCollection<Cita> listacitas { get; set; }


        public Logica()
        {
            listacitas = new ObservableCollection<Cita>();
            listacitas.Add(new Cita("Pedro", "Jimenez", "Si", DateTime.Now, "Sevilla", "Sala 2"));
        }

        public void AgregarCita(Cita cita)
        {
            listacitas.Add(cita);
        }

        public void EliminarCita(int index)
        {
            listacitas.RemoveAt(index);
        }

        public void EditarCita(int index, Cita cita)
        {
            listacitas[index] = cita;
        }

    }
}
