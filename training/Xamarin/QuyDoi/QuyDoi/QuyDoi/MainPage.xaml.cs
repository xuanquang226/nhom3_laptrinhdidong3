using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;


namespace QuyDoi
{
    public partial class MainPage : ContentPage
    {

        public MainPage()
        {
            InitializeComponent();
            btnQuyDoi.Clicked += BtnQuyDoi_Clicked;
        }

        private async void BtnQuyDoi_Clicked(object sender, EventArgs e)
        {

            if (string.IsNullOrEmpty(txtVND.Text))
            {
                await DisplayAlert("Lỗi", "Nhập số tiền trước khi thực hiện", "Chấp nhận");
                txtVND.Focus();
                return;
            }

            decimal VND = decimal.Parse(txtVND.Text);
            txtUSD.Text = string.Format("{0:N2}", QuyDoi2.ToUSD(VND));
            txtEuro.Text = string.Format("{0:N2}", QuyDoi2.ToEuro(VND));
            txtBPound.Text = string.Format("{0:N2}", QuyDoi2.ToBPound(VND));
            txtYen.Text = string.Format("{0:N2}", QuyDoi2.ToYen(VND));
        }
    }
}
