using Android.App;
using Android.Widget;
using Android.OS;
using Poke;

namespace FindPokemon
{
    [Activity(Label = "FindPokemon", MainLauncher = true)]
    public class MainActivity : Activity
    {
        private TextView txtName;
        private Button btnFind;
        private EditText edtTextNumber;
        private ImageView imageView;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);
            txtName = FindViewById<TextView>(Resource.Id.txtView2);
            btnFind = FindViewById<Button>(Resource.Id.btnFind);
            edtTextNumber = FindViewById<EditText>(Resource.Id.edtNumber);
            imageView = FindViewById<ImageView>(Resource.Id.imgView);


            btnFind.Click += BtnFind_Click;
        }

        private void BtnFind_Click(object sender, System.EventArgs e)
        {
            Pokedex pokedex = new Pokedex();
            int number = int.Parse(edtTextNumber.Text);
            txtName.Text = pokedex.GetPokemonName(number);
            imageView.SetImageBitmap(pokedex.GetPokemonBitmapImage(number));
        }
    }
}

