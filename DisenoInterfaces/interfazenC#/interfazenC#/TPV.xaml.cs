using System;
using System.Collections.Generic;
using System.Drawing;
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

namespace interfazenC_
{
    /// <summary>
    /// Lógica de interacción para TPV.xaml
    /// </summary>
    public partial class TPV : Window
    {
        public TPV()
        {
            InitializeComponent();

            for (int i = 0; i < 9;  i++)
            {
                RowDefinition rowleft = new RowDefinition();
                rowleft.Height = new GridLength(75, GridUnitType.Star);
                LeftGrid.RowDefinitions.Add(rowleft);
            }
            for (int i = 0; i < 9; i++)
            {
                RowDefinition rowrigth = new RowDefinition();
                rowrigth.Height = new GridLength(75, GridUnitType.Star);
                RigthGrid.RowDefinitions.Add(rowrigth);
            }
            for (int i = 0; i < 3; i++)
            {
                RowDefinition rows = new RowDefinition();
                rows.Height = new GridLength(75, GridUnitType.Star);
                elementsSelector.RowDefinitions.Add(rows);
            }
            for (int i = 0; i < 9; i++)
            {
                ColumnDefinition cols = new ColumnDefinition();
                cols.Width = new GridLength(75, GridUnitType.Star);
                elementsSelector.ColumnDefinitions.Add(cols);
            }
            for (int i = 0; i < 9; i++)
            {
                ColumnDefinition cols = new ColumnDefinition();
                cols.Width = new GridLength(75, GridUnitType.Star);
                elementsSelector2.ColumnDefinitions.Add(cols);
            }

            aplicarStyles();
        }

        private void aplicarStyles()
        {
            var buttons = calculadora.Children.OfType<Button>();

            LinearGradientBrush greenGradient = new LinearGradientBrush();
            greenGradient.GradientStops.Add(new GradientStop(System.Windows.Media.Color.FromRgb(198, 218, 202), 0));
            greenGradient.GradientStops.Add(new GradientStop(System.Windows.Media.Color.FromRgb(154, 190, 159), 1));

            Style buttonStyle = new Style();
            buttonStyle.Setters.Add(new Setter(Button.BackgroundProperty, greenGradient));

            Style borderStyle = new Style(typeof(Border));
            borderStyle.Setters.Add(new Setter(Border.CornerRadiusProperty, new CornerRadius(10)));

            foreach (Button button in buttons)
            {
                button.Style = buttonStyle;
                button.Resources.Add(typeof(Border), borderStyle);

            }

        }

    }
}
