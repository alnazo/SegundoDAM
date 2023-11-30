using DataGridBinding.dto;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace DataGridBinding
{
    /// <summary>
    /// Lógica de interacción para Formulario_citas.xaml
    /// </summary>
    public partial class Formulario_citas : Window
    {
        public Cita cita;
        private int index;

        public Formulario_citas()
        {
            InitializeComponent();
            this.index = -1;
            cita = new Cita();
            this.DataContext = cita;
        }

        public Formulario_citas(int index)
        {
            InitializeComponent();
            this.index = index;
            cita = new Cita();
            this.DataContext = Citas.logica.listacitas.ElementAt(index);
        }

        private void Agregar(Object sender, RoutedEventArgs e)
        {
            if (index > -1)
            {
                cita = new Cita(nombre.Text, apellidos.Text, grupo.Text, (DateTime)fecha.SelectedDate.GetValueOrDefault(), grupo.Text, sala.Text);
                Citas.logica.EditarCita(index, cita);
                this.Close();
            }
            else
            {
                Citas.logica.AgregarCita(cita);
            }

            cita = new Cita();
            this.DataContext = cita;
        }

        private void Cancelar(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}
