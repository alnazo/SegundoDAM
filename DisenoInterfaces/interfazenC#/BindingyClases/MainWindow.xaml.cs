using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace BindingyClases
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<jugadores> listaJugadores { get; set; }

        public MainWindow()
        {
            InitializeComponent();
            listaJugadores = new ObservableCollection<jugadores>();
            listaJugadores.Add(new jugadores("Manuel", "Jimenez"));
            listaJugadores.Add(new jugadores("Beatriz", "Campos"));
            this.DataContext = this;
        }

        private void BotonNuevo_Click(object sender, RoutedEventArgs e)
        {
            listaJugadores.Add(new jugadores("Nuevo", "Nuevo"));
        }
    }
}
