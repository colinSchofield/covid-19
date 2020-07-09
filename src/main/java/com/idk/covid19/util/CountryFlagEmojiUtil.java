package com.idk.covid19.util;

import com.idk.covid19.model.Region;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CountryFlagEmojiUtil {

    private CaseInsensitiveMap emojiRegionMapper = new CaseInsensitiveMap();

    public String getEmojiForCountry(String country) {
        String flagSymbol = emojiRegionMapper.get(country);
        return (flagSymbol != null) ? flagSymbol : "";
    }

    public CountryFlagEmojiUtil() {
        emojiRegionMapper.put("Australia", "🇦🇺", "AU");
        emojiRegionMapper.put("Canada", "🇨🇦", "CA");
        emojiRegionMapper.put("UK", "🇬🇧", "UK");
        emojiRegionMapper.put("USA", "🇺🇸", "US");
        emojiRegionMapper.put("China", "🇨🇳", "CN");
        emojiRegionMapper.put("Chile", "🇨🇱", "CL");
        emojiRegionMapper.put("New-Zealand", "🇳🇿", "NZ");
        emojiRegionMapper.put("Spain", "🇪🇸", "ES");
        emojiRegionMapper.put("Italy", "🇮🇹", "IT");
        emojiRegionMapper.put("Bahamas", "🇧🇸", "BS");
        emojiRegionMapper.put("Barbados", "🇧🇧", "BB");
        emojiRegionMapper.put("Brazil", "🇧🇷", "BR");
        emojiRegionMapper.put("Belgium", "🇧🇪", "BE");
        emojiRegionMapper.put("France", "🇫🇷", "FR");
        emojiRegionMapper.put("Poland", "🇵🇱", "PL");
        emojiRegionMapper.put("Peru", "🇵🇪", "PE");
        emojiRegionMapper.put("Russia", "🇷🇺", "RU");
        emojiRegionMapper.put("Germany", "🇩🇪", "DE");
        emojiRegionMapper.put("Iran", "🇮🇷", "IR");
        emojiRegionMapper.put("India", "🇮🇳", "IN");
        emojiRegionMapper.put("Mexico", "🇲🇽", "MX");
        emojiRegionMapper.put("Turkey", "🇹🇷", "TR");
        emojiRegionMapper.put("Saudi-Arabia", "🇸🇦", "SA");
        emojiRegionMapper.put("Antarctica", "🇦🇶", "AQ");
        emojiRegionMapper.put("Afghanistan", "🇦🇫", "AF");
        emojiRegionMapper.put("Åland-Islands", "🇦🇽", "AX");
        emojiRegionMapper.put("Albania", "🇦🇱", "AL");
        emojiRegionMapper.put("Algeria", "🇩🇿", "DZ");
        emojiRegionMapper.put("American-Samoa", "🇦🇸", "");
        emojiRegionMapper.put("Andorra", "🇦🇩", "AD");
        emojiRegionMapper.put("Angola", "🇦🇴", "AO");
        emojiRegionMapper.put("Anguilla", "🇦🇮", "AI");
        emojiRegionMapper.put("Antigua-and-Barbuda", "🇦🇬", "AG");
        emojiRegionMapper.put("Argentina", "🇦🇷", "AR");
        emojiRegionMapper.put("Armenia", "🇦🇲", "AM");
        emojiRegionMapper.put("Aruba", "🇦🇼", "AW");
        emojiRegionMapper.put("Austria", "🇦🇹", "AT");
        emojiRegionMapper.put("Azerbaijan", "🇦🇿", "AZ");
        emojiRegionMapper.put("Bahrain", "🇧🇭", "BH");
        emojiRegionMapper.put("Bangladesh", "🇧🇩", "BD");
        emojiRegionMapper.put("Belarus", "🇧🇾", "BY");
        emojiRegionMapper.put("Belize", "🇧🇿", "BZ");
        emojiRegionMapper.put("Benin", "🇧🇯", "BJ");
        emojiRegionMapper.put("Bermuda", "🇧🇲", "BM");
        emojiRegionMapper.put("Bhutan", "🇧🇹", "BT");
        emojiRegionMapper.put("Bolivia", "🇧🇴", "BO");
        emojiRegionMapper.put("Bosnia-and-Herzegovina", "🇧🇦", "BA");
        emojiRegionMapper.put("Botswana", "🇧🇼", "BW");
        emojiRegionMapper.put("Bouvet-Island", "🇧🇻", "BV");
        emojiRegionMapper.put("British-Indian-Ocean-Territory", "🇮🇴", "IO");
        emojiRegionMapper.put("Brunei", "🇧🇳", "BN");
        emojiRegionMapper.put("Bulgaria", "🇧🇬", "BG");
        emojiRegionMapper.put("Burkina-Faso", "🇧🇫", "BF");
        emojiRegionMapper.put("Burundi", "🇧🇮", "BI");
        emojiRegionMapper.put("Cambodia", "🇰🇭", "KH");
        emojiRegionMapper.put("Cameroon", "🇨🇲", "CM");
        emojiRegionMapper.put("Cabo-Verde", "🇨🇻", "CV");
        emojiRegionMapper.put("Caribbean-Netherlands", "🇧🇶", "");
        emojiRegionMapper.put("Cayman-Islands", "🇰🇾", "KY");
        emojiRegionMapper.put("CAR", "🇨🇫", "CF");
        emojiRegionMapper.put("Chad", "🇹🇩", "TD");
        emojiRegionMapper.put("Christmas-Island", "🇨🇽", "CX");
        emojiRegionMapper.put("Cocos-(Keeling)-Islands", "🇨🇨", "CC");
        emojiRegionMapper.put("Colombia", "🇨🇴", "CO");
        emojiRegionMapper.put("Comoros", "🇰🇲", "KM");
        emojiRegionMapper.put("DRC", "🇨🇬", "CD");
        emojiRegionMapper.put("Congo", "🇨🇩", "CG");
        emojiRegionMapper.put("Cook-Islands", "🇨🇰", "CK");
        emojiRegionMapper.put("Costa-Rica", "🇨🇷", "CR");
        emojiRegionMapper.put("Ivory-Coast", "🇨🇮", "CI");
        emojiRegionMapper.put("Croatia", "🇭🇷", "HR");
        emojiRegionMapper.put("Cuba", "🇨🇺", "CU");
        emojiRegionMapper.put("Curaçao", "🇨🇼", "CW");
        emojiRegionMapper.put("Cyprus", "🇨🇾", "CY");
        emojiRegionMapper.put("Czechia", "🇨🇿", "CZ");
        emojiRegionMapper.put("Denmark", "🇩🇰", "DK");
        emojiRegionMapper.put("Djibouti", "🇩🇯", "DJ");
        emojiRegionMapper.put("Dominica", "🇩🇲", "DM");
        emojiRegionMapper.put("Dominican-Republic", "🇩🇴", "DO");
        emojiRegionMapper.put("Ecuador", "🇪🇨", "EC");
        emojiRegionMapper.put("Egypt", "🇪🇬", "EG");
        emojiRegionMapper.put("El-Salvador", "🇸🇻", "SV");
        emojiRegionMapper.put("󠁥󠁮󠁧󠁿England", "🏴󠁧󠁢", "");
        emojiRegionMapper.put("Equatorial-Guinea", "🇬🇶", "");
        emojiRegionMapper.put("Eritrea", "🇪🇷", "ER");
        emojiRegionMapper.put("Estonia", "🇪🇪", "EE");
        emojiRegionMapper.put("Eswatini", "🇸🇿", "SZ");
        emojiRegionMapper.put("Ethiopia", "🇪🇹", "ET");
        emojiRegionMapper.put("Falkland-Islands", "🇫🇰", "FK");
        emojiRegionMapper.put("Faeroe-Islands", "🇫🇴", "FO");
        emojiRegionMapper.put("Fiji", "🇫🇯", "FJ");
        emojiRegionMapper.put("Finland", "🇫🇮", "FI");
        emojiRegionMapper.put("French-Guiana", "🇬🇫", "GF");
        emojiRegionMapper.put("French-Polynesia", "🇵🇫", "PF");
        emojiRegionMapper.put("French-Southern-and-Antarctic-Lands", "🇹🇫", "TF");
        emojiRegionMapper.put("Gabon", "🇬🇦", "GA");
        emojiRegionMapper.put("Gambia", "🇬🇲", "GM");
        emojiRegionMapper.put("Georgia", "🇬🇪", "GE");
        emojiRegionMapper.put("Ghana", "🇬🇭", "GH");
        emojiRegionMapper.put("Gibraltar", "🇬🇮", "GI");
        emojiRegionMapper.put("Greece", "🇬🇷", "GR");
        emojiRegionMapper.put("Greenland", "🇬🇱", "GL");
        emojiRegionMapper.put("Grenada", "🇬🇩", "GD");
        emojiRegionMapper.put("Guadeloupe", "🇬🇵", "GP");
        emojiRegionMapper.put("Guam", "🇬🇺", "GU");
        emojiRegionMapper.put("Guatemala", "🇬🇹", "GT");
        emojiRegionMapper.put("Guernsey", "🇬🇬", "GG");
        emojiRegionMapper.put("Guinea", "🇬🇳", "GN");
        emojiRegionMapper.put("Guinea-Bissau", "🇬🇼", "GW");
        emojiRegionMapper.put("Guyana", "🇬🇾", "GY");
        emojiRegionMapper.put("Haiti", "🇭🇹", "HT");
        emojiRegionMapper.put("Heard-Island-and-McDonald-Islands", "🇭🇲", "HM");
        emojiRegionMapper.put("Honduras", "🇭🇳", "HN");
        emojiRegionMapper.put("Hong-Kong", "🇭🇰", "HK");
        emojiRegionMapper.put("Hungary", "🇭🇺", "HU");
        emojiRegionMapper.put("Iceland", "🇮🇸", "IS");
        emojiRegionMapper.put("Indonesia", "🇮🇩", "ID");
        emojiRegionMapper.put("Iraq", "🇮🇶", "IQ");
        emojiRegionMapper.put("Ireland", "🇮🇪", "IE");
        emojiRegionMapper.put("Isle-of-Man", "🇮🇲", "IM");
        emojiRegionMapper.put("Israel", "🇮🇱", "IL");
        emojiRegionMapper.put("Jamaica", "🇯🇲", "JM");
        emojiRegionMapper.put("Japan", "🇯🇵", "JP");
        emojiRegionMapper.put("Channel-Islands", "🇯🇪", "JE");
        emojiRegionMapper.put("Jordan", "🇯🇴", "JO");
        emojiRegionMapper.put("Kazakhstan", "🇰🇿", "KZ");
        emojiRegionMapper.put("Kenya", "🇰🇪", "KE");
        emojiRegionMapper.put("Kiribati", "🇰🇮", "KI");
        emojiRegionMapper.put("N-Korea", "🇰🇵", "KP");
        emojiRegionMapper.put("S-Korea", "🇰🇷", "KR");
        emojiRegionMapper.put("Kosovo", "🇽🇰", "");
        emojiRegionMapper.put("Kuwait", "🇰🇼", "KW");
        emojiRegionMapper.put("Kyrgyzstan", "🇰🇬", "KG");
        emojiRegionMapper.put("Laos", "🇱🇦", "LA");
        emojiRegionMapper.put("Latvia", "🇱🇻", "LV");
        emojiRegionMapper.put("Lebanon", "🇱🇧", "LB");
        emojiRegionMapper.put("Lesotho", "🇱🇸", "LS");
        emojiRegionMapper.put("Liberia", "🇱🇷", "LR");
        emojiRegionMapper.put("Libya", "🇱🇾", "LY");
        emojiRegionMapper.put("Liechtenstein", "🇱🇮", "LI");
        emojiRegionMapper.put("Lithuania", "🇱🇹", "LT");
        emojiRegionMapper.put("Luxembourg", "🇱🇺", "LU");
        emojiRegionMapper.put("Macao", "🇲🇴", "MO");
        emojiRegionMapper.put("Madagascar", "🇲🇬", "MG");
        emojiRegionMapper.put("Malawi", "🇲🇼", "MW");
        emojiRegionMapper.put("Malaysia", "🇲🇾", "MY");
        emojiRegionMapper.put("Maldives", "🇲🇻", "MV");
        emojiRegionMapper.put("Mali", "🇲🇱", "ML");
        emojiRegionMapper.put("Malta", "🇲🇹", "MT");
        emojiRegionMapper.put("Marshall-Islands", "🇲🇭", "MH");
        emojiRegionMapper.put("Martinique", "🇲🇶", "MQ");
        emojiRegionMapper.put("Mauritania", "🇲🇷", "MR");
        emojiRegionMapper.put("Mauritius", "🇲🇺", "MU");
        emojiRegionMapper.put("Mayotte", "🇾🇹", "YT");
        emojiRegionMapper.put("Micronesia", "🇫🇲", "FM");
        emojiRegionMapper.put("Moldova", "🇲🇩", "MD");
        emojiRegionMapper.put("Monaco", "🇲🇨", "MC");
        emojiRegionMapper.put("Mongolia", "🇲🇳", "MN");
        emojiRegionMapper.put("Montenegro", "🇲🇪", "ME");
        emojiRegionMapper.put("Montserrat", "🇲🇸", "MS");
        emojiRegionMapper.put("Morocco", "🇲🇦", "MA");
        emojiRegionMapper.put("Mozambique", "🇲🇿", "MZ");
        emojiRegionMapper.put("Myanmar", "🇲🇲", "MM");
        emojiRegionMapper.put("Namibia", "🇳🇦", "NA");
        emojiRegionMapper.put("Nauru", "🇳🇷", "NR");
        emojiRegionMapper.put("Nepal", "🇳🇵", "NP");
        emojiRegionMapper.put("Netherlands", "🇳🇱", "NL");
        emojiRegionMapper.put("New-Caledonia", "🇳🇨", "NC");
        emojiRegionMapper.put("Nicaragua", "🇳🇮", "NI");
        emojiRegionMapper.put("Niger", "🇳🇪", "NE");
        emojiRegionMapper.put("Nigeria", "🇳🇬", "NG");
        emojiRegionMapper.put("Niue", "🇳🇺", "NU");
        emojiRegionMapper.put("Norfolk-Island", "🇳🇫", "NF");
        emojiRegionMapper.put("North-Macedonia", "🇲🇰", "MK");
        emojiRegionMapper.put("Northern-Mariana-Islands", "🇲🇵", "MP");
        emojiRegionMapper.put("Norway", "🇳🇴", "NO");
        emojiRegionMapper.put("Oman", "🇴🇲", "OM");
        emojiRegionMapper.put("Pakistan", "🇵🇰", "PK");
        emojiRegionMapper.put("Palau", "🇵🇼", "PW");
        emojiRegionMapper.put("Palestine", "🇵🇸", "PS");
        emojiRegionMapper.put("Panama", "🇵🇦", "PA");
        emojiRegionMapper.put("Papua-New-Guinea", "🇵🇬", "PG");
        emojiRegionMapper.put("Paraguay", "🇵🇾", "PY");
        emojiRegionMapper.put("Philippines", "🇵🇭", "PH");
        emojiRegionMapper.put("Pitcairn-Islands", "🇵🇳", "PN");
        emojiRegionMapper.put("Portugal", "🇵🇹", "PT");
        emojiRegionMapper.put("Puerto-Rico", "🇵🇷", "PR");
        emojiRegionMapper.put("Qatar", "🇶🇦", "QA");
        emojiRegionMapper.put("Réunion", "🇷🇪", "RE");
        emojiRegionMapper.put("Romania", "🇷🇴", "RO");
        emojiRegionMapper.put("Rwanda", "🇷🇼", "RW");
        emojiRegionMapper.put("St-Barth", "🇧🇱", "BL");
        emojiRegionMapper.put("Saint-Helena", "🇸🇭", "SH");
        emojiRegionMapper.put("Saint-Kitts-and-Nevis", "🇰🇳", "KN");
        emojiRegionMapper.put("Saint-Lucia", "🇱🇨", "LC");
        emojiRegionMapper.put("Saint-Martin", "🇲🇫", "MF");
        emojiRegionMapper.put("Saint-Pierre-Miquelon", "🇵🇲", "PM");
        emojiRegionMapper.put("St-Vincent-Grenadines", "🇻🇨", "VC");
        emojiRegionMapper.put("Samoa", "🇼🇸", "WS");
        emojiRegionMapper.put("San-Marino", "🇸🇲", "SM");
        emojiRegionMapper.put("Sao-Tome-and-Principe", "🇸🇹", "ST");
        emojiRegionMapper.put("󠁳󠁣󠁴󠁿Scotland", "🏴󠁧󠁢", "");
        emojiRegionMapper.put("Senegal", "🇸🇳", "SN");
        emojiRegionMapper.put("Serbia", "🇷🇸", "RS");
        emojiRegionMapper.put("Seychelles", "🇸🇨", "SC");
        emojiRegionMapper.put("Sierra-Leone", "🇸🇱", "SL");
        emojiRegionMapper.put("Singapore", "🇸🇬", "SG");
        emojiRegionMapper.put("Sint-Maarten", "🇸🇽", "");
        emojiRegionMapper.put("Slovakia", "🇸🇰", "SK");
        emojiRegionMapper.put("Slovenia", "🇸🇮", "SI");
        emojiRegionMapper.put("Solomon-Islands", "🇸🇧", "SB");
        emojiRegionMapper.put("Somalia", "🇸🇴", "SO");
        emojiRegionMapper.put("South-Africa", "🇿🇦", "ZA");
        emojiRegionMapper.put("South-Georgia", "🇬🇸", "GS");
        emojiRegionMapper.put("South-Sudan", "🇸🇸", "SS");
        emojiRegionMapper.put("Sri-Lanka", "🇱🇰", "LK");
        emojiRegionMapper.put("Sudan", "🇸🇩", "SD");
        emojiRegionMapper.put("Suriname", "🇸🇷", "SR");
        emojiRegionMapper.put("Svalbard-and-Jan-Mayen", "🇸🇯", "SJ");
        emojiRegionMapper.put("Sweden", "🇸🇪", "SE");
        emojiRegionMapper.put("Switzerland", "🇨🇭", "CH");
        emojiRegionMapper.put("Syria", "🇸🇾", "SY");
        emojiRegionMapper.put("Taiwan", "🇹🇼", "TW");
        emojiRegionMapper.put("Tajikistan", "🇹🇯", "TJ");
        emojiRegionMapper.put("Tanzania", "🇹🇿", "TZ");
        emojiRegionMapper.put("Thailand", "🇹🇭", "TH");
        emojiRegionMapper.put("Timor-Leste", "🇹🇱", "TL");
        emojiRegionMapper.put("Togo", "🇹🇬", "TG");
        emojiRegionMapper.put("Tokelau", "🇹🇰", "TK");
        emojiRegionMapper.put("Tonga", "🇹🇴", "TO");
        emojiRegionMapper.put("Trinidad-and-Tobago", "🇹🇹", "TT");
        emojiRegionMapper.put("Tunisia", "🇹🇳", "TN");
        emojiRegionMapper.put("Turkmenistan", "🇹🇲", "TM");
        emojiRegionMapper.put("Turks-and-Caicos", "🇹🇨", "TC");
        emojiRegionMapper.put("Tuvalu", "🇹🇻", "TV");
        emojiRegionMapper.put("Uganda", "🇺🇬", "UG");
        emojiRegionMapper.put("Ukraine", "🇺🇦", "UA");
        emojiRegionMapper.put("UAE", "🇦🇪", "AE");
        emojiRegionMapper.put("United-States-Minor-Outlying-Islands", "🇺🇲", "UM");
        emojiRegionMapper.put("Uruguay", "🇺🇾", "UY");
        emojiRegionMapper.put("Uzbekistan", "🇺🇿", "UZ");
        emojiRegionMapper.put("Vanuatu", "🇻🇺", "VU");
        emojiRegionMapper.put("Vatican-City", "🇻🇦", "VA");
        emojiRegionMapper.put("Venezuela", "🇻🇪", "VE");
        emojiRegionMapper.put("Vietnam", "🇻🇳", "VN");
        emojiRegionMapper.put("British-Virgin-Islands", "🇻🇬", "VG");
        emojiRegionMapper.put("US-Virgin-Islands", "🇻🇮", "VI");
        emojiRegionMapper.put("󠁷󠁬󠁳󠁿Wales", "🏴󠁧󠁢", "");
        emojiRegionMapper.put("Wallis-and-Futuna", "🇼🇫", "WF");
        emojiRegionMapper.put("Western-Sahara", "🇪🇭", "EH");
        emojiRegionMapper.put("Yemen", "🇾🇪", "YE");
        emojiRegionMapper.put("Zambia", "🇿🇲", "ZM");
        emojiRegionMapper.put("Zimbabwe", "🇿🇼", "ZW");
    }

    public List<Region> getRegionList() {
        return emojiRegionMapper.getListOfRegions();
    }

    public static class CaseInsensitiveMap extends HashMap<String, String> {

        private List<Region> listOfRegions = new ArrayList<>();

        private String locationDecorator(String location) {
            if (location == null) {
                return null;
            }

            StringBuilder sb = new StringBuilder();
            for (String word : location.split("-")) {
                sb.append(WordUtils.capitalize(word));
                sb.append(" ");
            }
            return sb.toString().trim();
        }

        public String put(String key, String value, String countryCode) {
            getListOfRegions().add(new Region(key, locationDecorator(key), countryCode, value));
            return super.put(key.toLowerCase(), value);
        }

        public String get(String key) {
            return super.get(key.toLowerCase());
        }

        public List<Region> getListOfRegions() {
            return listOfRegions;
        }
    }
}
