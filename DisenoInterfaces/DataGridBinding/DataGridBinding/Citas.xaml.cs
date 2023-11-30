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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace DataGridBinding
{
    /// <summary>
    /// Interaction logic for Citas.xaml
    /// </summary>
    public partial class Citas : Window
    {
        public static Logica logica = new Logica();

        public Citas()
        {
            InitializeComponent();
            datagrid.DataContext = logica;
        }
        
        private void EditarCita(object sender, RoutedEventArgs e)
        {
            if (datagrid.SelectedIndex != -1)
            {
                new Formulario_citas(datagrid.SelectedIndex).Show();
            }
        }

        private void CitaNueva(object sender, RoutedEventArgs e)
        {
            new Formulario_citas().Show();
        }

        private void EliminarCita(object sender, RoutedEventArgs e)
        {
            logica.EliminarCita(datagrid.SelectedIndex);
        }
    }
}
