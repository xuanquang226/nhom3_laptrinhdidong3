using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuyDoi
{
    public class QuyDoi2
    {
        public static decimal ToUSD(decimal VND) {
            return VND / (decimal)22727.2727;
        }

        public static decimal ToEuro(decimal VND)
        {
            return VND / (decimal)27120.4545;
        }

        public static decimal ToBPound(decimal VND)
        {
            return VND / (decimal)30307.9545;
        }

        public static decimal ToYen(decimal VND)
        {
            return VND / (decimal)203.795455;
        }
    }
}
