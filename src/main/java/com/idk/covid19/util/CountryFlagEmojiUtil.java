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
        emojiRegionMapper.put("Australia", "🇦🇺");
        emojiRegionMapper.put("Canada", "🇨🇦");
        emojiRegionMapper.put("UK", "🇬🇧");
        emojiRegionMapper.put("USA", "🇺🇸");
        emojiRegionMapper.put("China", "🇨🇳");
        emojiRegionMapper.put("Chile", "🇨🇱");
        emojiRegionMapper.put("New-Zealand", "🇳🇿");
        emojiRegionMapper.put("Spain", "🇪🇸");
        emojiRegionMapper.put("Italy", "🇮🇹");
        emojiRegionMapper.put("Bahamas", "🇧🇸");
        emojiRegionMapper.put("Barbados", "🇧🇧");
        emojiRegionMapper.put("Brazil", "🇧🇷");
        emojiRegionMapper.put("Belgium", "🇧🇪");
        emojiRegionMapper.put("France", "🇫🇷");
        emojiRegionMapper.put("Poland", "🇵🇱");
        emojiRegionMapper.put("Peru", "🇵🇪");
        emojiRegionMapper.put("Russia", "🇷🇺");
        emojiRegionMapper.put("Germany", "🇩🇪");
        emojiRegionMapper.put("Iran", "🇮🇷");
        emojiRegionMapper.put("India", "🇮🇳");
        emojiRegionMapper.put("Mexico", "🇲🇽");
        emojiRegionMapper.put("Turkey", "🇹🇷");
        emojiRegionMapper.put("Saudi-Arabia", "🇸🇦");
        emojiRegionMapper.put("Antarctica", "🇦🇶");
        emojiRegionMapper.put("Afghanistan", "🇦🇫");
        emojiRegionMapper.put("Åland-Islands", "🇦🇽");
        emojiRegionMapper.put("Albania", "🇦🇱");
        emojiRegionMapper.put("Algeria", "🇩🇿");
        emojiRegionMapper.put("American-Samoa", "🇦🇸");
        emojiRegionMapper.put("Andorra", "🇦🇩");
        emojiRegionMapper.put("Angola", "🇦🇴");
        emojiRegionMapper.put("Anguilla", "🇦🇮");
        emojiRegionMapper.put("Antigua-and-Barbuda", "🇦🇬");
        emojiRegionMapper.put("Argentina", "🇦🇷");
        emojiRegionMapper.put("Armenia", "🇦🇲");
        emojiRegionMapper.put("Aruba", "🇦🇼");
        emojiRegionMapper.put("Austria", "🇦🇹");
        emojiRegionMapper.put("Azerbaijan", "🇦🇿");
        emojiRegionMapper.put("Bahrain", "🇧🇭");
        emojiRegionMapper.put("Bangladesh", "🇧🇩");
        emojiRegionMapper.put("Belarus", "🇧🇾");
        emojiRegionMapper.put("Belize", "🇧🇿");
        emojiRegionMapper.put("Benin", "🇧🇯");
        emojiRegionMapper.put("Bermuda", "🇧🇲");
        emojiRegionMapper.put("Bhutan", "🇧🇹");
        emojiRegionMapper.put("Bolivia", "🇧🇴");
        emojiRegionMapper.put("Bosnia-and-Herzegovina", "🇧🇦");
        emojiRegionMapper.put("Botswana", "🇧🇼");
        emojiRegionMapper.put("Bouvet-Island", "🇧🇻");
        emojiRegionMapper.put("British-Indian-Ocean-Territory", "🇮🇴");
        emojiRegionMapper.put("Brunei", "🇧🇳");
        emojiRegionMapper.put("Bulgaria", "🇧🇬");
        emojiRegionMapper.put("Burkina-Faso", "🇧🇫");
        emojiRegionMapper.put("Burundi", "🇧🇮");
        emojiRegionMapper.put("Cambodia", "🇰🇭");
        emojiRegionMapper.put("Cameroon", "🇨🇲");
        emojiRegionMapper.put("Cape-Verde", "🇨🇻");
        emojiRegionMapper.put("Caribbean-Netherlands", "🇧🇶");
        emojiRegionMapper.put("Cayman-Islands", "🇰🇾");
        emojiRegionMapper.put("Central-African-Republic", "🇨🇫");
        emojiRegionMapper.put("Chad", "🇹🇩");
        emojiRegionMapper.put("Christmas-Island", "🇨🇽");
        emojiRegionMapper.put("Cocos-(Keeling)-Islands", "🇨🇨");
        emojiRegionMapper.put("Colombia", "🇨🇴");
        emojiRegionMapper.put("Comoros", "🇰🇲");
        emojiRegionMapper.put("Republic-of-the-Congo", "🇨🇬");
        emojiRegionMapper.put("DR-Congo", "🇨🇩");
        emojiRegionMapper.put("Cook-Islands", "🇨🇰");
        emojiRegionMapper.put("Costa-Rica", "🇨🇷");
        emojiRegionMapper.put("Côte-d'Ivoire-(Ivory-Coast)", "🇨🇮");
        emojiRegionMapper.put("Croatia", "🇭🇷");
        emojiRegionMapper.put("Cuba", "🇨🇺");
        emojiRegionMapper.put("Curaçao", "🇨🇼");
        emojiRegionMapper.put("Cyprus", "🇨🇾");
        emojiRegionMapper.put("Czechia", "🇨🇿");
        emojiRegionMapper.put("Denmark", "🇩🇰");
        emojiRegionMapper.put("Djibouti", "🇩🇯");
        emojiRegionMapper.put("Dominica", "🇩🇲");
        emojiRegionMapper.put("Dominican-Republic", "🇩🇴");
        emojiRegionMapper.put("Ecuador", "🇪🇨");
        emojiRegionMapper.put("Egypt", "🇪🇬");
        emojiRegionMapper.put("El-Salvador", "🇸🇻");
        emojiRegionMapper.put("󠁥󠁮󠁧󠁿England", "🏴󠁧󠁢");
        emojiRegionMapper.put("Equatorial-Guinea", "🇬🇶");
        emojiRegionMapper.put("Eritrea", "🇪🇷");
        emojiRegionMapper.put("Estonia", "🇪🇪");
        emojiRegionMapper.put("Eswatini-(Swaziland)", "🇸🇿");
        emojiRegionMapper.put("Ethiopia", "🇪🇹");
        emojiRegionMapper.put("Falkland-Islands", "🇫🇰");
        emojiRegionMapper.put("Faroe-Islands", "🇫🇴");
        emojiRegionMapper.put("Fiji", "🇫🇯");
        emojiRegionMapper.put("Finland", "🇫🇮");
        emojiRegionMapper.put("French-Guiana", "🇬🇫");
        emojiRegionMapper.put("French-Polynesia", "🇵🇫");
        emojiRegionMapper.put("French-Southern-and-Antarctic-Lands", "🇹🇫");
        emojiRegionMapper.put("Gabon", "🇬🇦");
        emojiRegionMapper.put("Gambia", "🇬🇲");
        emojiRegionMapper.put("Georgia", "🇬🇪");
        emojiRegionMapper.put("Ghana", "🇬🇭");
        emojiRegionMapper.put("Gibraltar", "🇬🇮");
        emojiRegionMapper.put("Greece", "🇬🇷");
        emojiRegionMapper.put("Greenland", "🇬🇱");
        emojiRegionMapper.put("Grenada", "🇬🇩");
        emojiRegionMapper.put("Guadeloupe", "🇬🇵");
        emojiRegionMapper.put("Guam", "🇬🇺");
        emojiRegionMapper.put("Guatemala", "🇬🇹");
        emojiRegionMapper.put("Guernsey", "🇬🇬");
        emojiRegionMapper.put("Guinea", "🇬🇳");
        emojiRegionMapper.put("Guinea-Bissau", "🇬🇼");
        emojiRegionMapper.put("Guyana", "🇬🇾");
        emojiRegionMapper.put("Haiti", "🇭🇹");
        emojiRegionMapper.put("Heard-Island-and-McDonald-Islands", "🇭🇲");
        emojiRegionMapper.put("Honduras", "🇭🇳");
        emojiRegionMapper.put("Hong-Kong", "🇭🇰");
        emojiRegionMapper.put("Hungary", "🇭🇺");
        emojiRegionMapper.put("Iceland", "🇮🇸");
        emojiRegionMapper.put("Indonesia", "🇮🇩");
        emojiRegionMapper.put("Iraq", "🇮🇶");
        emojiRegionMapper.put("Ireland", "🇮🇪");
        emojiRegionMapper.put("Isle-of-Man", "🇮🇲");
        emojiRegionMapper.put("Israel", "🇮🇱");
        emojiRegionMapper.put("Jamaica", "🇯🇲");
        emojiRegionMapper.put("Japan", "🇯🇵");
        emojiRegionMapper.put("Jersey", "🇯🇪");
        emojiRegionMapper.put("Jordan", "🇯🇴");
        emojiRegionMapper.put("Kazakhstan", "🇰🇿");
        emojiRegionMapper.put("Kenya", "🇰🇪");
        emojiRegionMapper.put("Kiribati", "🇰🇮");
        emojiRegionMapper.put("N-Korea", "🇰🇵");
        emojiRegionMapper.put("S-Korea", "🇰🇷");
        emojiRegionMapper.put("Kosovo", "🇽🇰");
        emojiRegionMapper.put("Kuwait", "🇰🇼");
        emojiRegionMapper.put("Kyrgyzstan", "🇰🇬");
        emojiRegionMapper.put("Laos", "🇱🇦");
        emojiRegionMapper.put("Latvia", "🇱🇻");
        emojiRegionMapper.put("Lebanon", "🇱🇧");
        emojiRegionMapper.put("Lesotho", "🇱🇸");
        emojiRegionMapper.put("Liberia", "🇱🇷");
        emojiRegionMapper.put("Libya", "🇱🇾");
        emojiRegionMapper.put("Liechtenstein", "🇱🇮");
        emojiRegionMapper.put("Lithuania", "🇱🇹");
        emojiRegionMapper.put("Luxembourg", "🇱🇺");
        emojiRegionMapper.put("Macau", "🇲🇴");
        emojiRegionMapper.put("Madagascar", "🇲🇬");
        emojiRegionMapper.put("Malawi", "🇲🇼");
        emojiRegionMapper.put("Malaysia", "🇲🇾");
        emojiRegionMapper.put("Maldives", "🇲🇻");
        emojiRegionMapper.put("Mali", "🇲🇱");
        emojiRegionMapper.put("Malta", "🇲🇹");
        emojiRegionMapper.put("Marshall-Islands", "🇲🇭");
        emojiRegionMapper.put("Martinique", "🇲🇶");
        emojiRegionMapper.put("Mauritania", "🇲🇷");
        emojiRegionMapper.put("Mauritius", "🇲🇺");
        emojiRegionMapper.put("Mayotte", "🇾🇹");
        emojiRegionMapper.put("Micronesia", "🇫🇲");
        emojiRegionMapper.put("Moldova", "🇲🇩");
        emojiRegionMapper.put("Monaco", "🇲🇨");
        emojiRegionMapper.put("Mongolia", "🇲🇳");
        emojiRegionMapper.put("Montenegro", "🇲🇪");
        emojiRegionMapper.put("Montserrat", "🇲🇸");
        emojiRegionMapper.put("Morocco", "🇲🇦");
        emojiRegionMapper.put("Mozambique", "🇲🇿");
        emojiRegionMapper.put("Myanmar", "🇲🇲");
        emojiRegionMapper.put("Namibia", "🇳🇦");
        emojiRegionMapper.put("Nauru", "🇳🇷");
        emojiRegionMapper.put("Nepal", "🇳🇵");
        emojiRegionMapper.put("Netherlands", "🇳🇱");
        emojiRegionMapper.put("New-Caledonia", "🇳🇨");
        emojiRegionMapper.put("Nicaragua", "🇳🇮");
        emojiRegionMapper.put("Niger", "🇳🇪");
        emojiRegionMapper.put("Nigeria", "🇳🇬");
        emojiRegionMapper.put("Niue", "🇳🇺");
        emojiRegionMapper.put("Norfolk-Island", "🇳🇫");
        emojiRegionMapper.put("North-Macedonia", "🇲🇰");
        emojiRegionMapper.put("Northern-Mariana-Islands", "🇲🇵");
        emojiRegionMapper.put("Norway", "🇳🇴");
        emojiRegionMapper.put("Oman", "🇴🇲");
        emojiRegionMapper.put("Pakistan", "🇵🇰");
        emojiRegionMapper.put("Palau", "🇵🇼");
        emojiRegionMapper.put("Palestine", "🇵🇸");
        emojiRegionMapper.put("Panama", "🇵🇦");
        emojiRegionMapper.put("Papua-New-Guinea", "🇵🇬");
        emojiRegionMapper.put("Paraguay", "🇵🇾");
        emojiRegionMapper.put("Philippines", "🇵🇭");
        emojiRegionMapper.put("Pitcairn-Islands", "🇵🇳");
        emojiRegionMapper.put("Portugal", "🇵🇹");
        emojiRegionMapper.put("Puerto-Rico", "🇵🇷");
        emojiRegionMapper.put("Qatar", "🇶🇦");
        emojiRegionMapper.put("Réunion", "🇷🇪");
        emojiRegionMapper.put("Romania", "🇷🇴");
        emojiRegionMapper.put("Rwanda", "🇷🇼");
        emojiRegionMapper.put("Saint-Barthélemy", "🇧🇱");
        emojiRegionMapper.put("Saint-Helena", "🇸🇭");
        emojiRegionMapper.put("Saint-Kitts-and-Nevis", "🇰🇳");
        emojiRegionMapper.put("Saint-Lucia", "🇱🇨");
        emojiRegionMapper.put("Saint-Martin", "🇲🇫");
        emojiRegionMapper.put("Saint-Pierre-and-Miquelon", "🇵🇲");
        emojiRegionMapper.put("Saint-Vincent-and-the-Grenadines", "🇻🇨");
        emojiRegionMapper.put("Samoa", "🇼🇸");
        emojiRegionMapper.put("San-Marino", "🇸🇲");
        emojiRegionMapper.put("São-Tomé-and-Príncipe", "🇸🇹");
        emojiRegionMapper.put("󠁳󠁣󠁴󠁿Scotland", "🏴󠁧󠁢");
        emojiRegionMapper.put("Senegal", "🇸🇳");
        emojiRegionMapper.put("Serbia", "🇷🇸");
        emojiRegionMapper.put("Seychelles", "🇸🇨");
        emojiRegionMapper.put("Sierra-Leone", "🇸🇱");
        emojiRegionMapper.put("Singapore", "🇸🇬");
        emojiRegionMapper.put("Sint-Maarten", "🇸🇽");
        emojiRegionMapper.put("Slovakia", "🇸🇰");
        emojiRegionMapper.put("Slovenia", "🇸🇮");
        emojiRegionMapper.put("Solomon-Islands", "🇸🇧");
        emojiRegionMapper.put("Somalia", "🇸🇴");
        emojiRegionMapper.put("South-Africa", "🇿🇦");
        emojiRegionMapper.put("South-Georgia", "🇬🇸");
        emojiRegionMapper.put("South-Sudan", "🇸🇸");
        emojiRegionMapper.put("Sri-Lanka", "🇱🇰");
        emojiRegionMapper.put("Sudan", "🇸🇩");
        emojiRegionMapper.put("Suriname", "🇸🇷");
        emojiRegionMapper.put("Svalbard-and-Jan-Mayen", "🇸🇯");
        emojiRegionMapper.put("Sweden", "🇸🇪");
        emojiRegionMapper.put("Switzerland", "🇨🇭");
        emojiRegionMapper.put("Syria", "🇸🇾");
        emojiRegionMapper.put("Taiwan", "🇹🇼");
        emojiRegionMapper.put("Tajikistan", "🇹🇯");
        emojiRegionMapper.put("Tanzania", "🇹🇿");
        emojiRegionMapper.put("Thailand", "🇹🇭");
        emojiRegionMapper.put("Timor-Leste", "🇹🇱");
        emojiRegionMapper.put("Togo", "🇹🇬");
        emojiRegionMapper.put("Tokelau", "🇹🇰");
        emojiRegionMapper.put("Tonga", "🇹🇴");
        emojiRegionMapper.put("Trinidad-and-Tobago", "🇹🇹");
        emojiRegionMapper.put("Tunisia", "🇹🇳");
        emojiRegionMapper.put("Turkmenistan", "🇹🇲");
        emojiRegionMapper.put("Turks-and-Caicos-Islands", "🇹🇨");
        emojiRegionMapper.put("Tuvalu", "🇹🇻");
        emojiRegionMapper.put("Uganda", "🇺🇬");
        emojiRegionMapper.put("Ukraine", "🇺🇦");
        emojiRegionMapper.put("United-Arab-Emirates", "🇦🇪");
        emojiRegionMapper.put("United-States-Minor-Outlying-Islands", "🇺🇲");
        emojiRegionMapper.put("Uruguay", "🇺🇾");
        emojiRegionMapper.put("Uzbekistan", "🇺🇿");
        emojiRegionMapper.put("Vanuatu", "🇻🇺");
        emojiRegionMapper.put("Vatican-City-(Holy-See)", "🇻🇦");
        emojiRegionMapper.put("Venezuela", "🇻🇪");
        emojiRegionMapper.put("Vietnam", "🇻🇳");
        emojiRegionMapper.put("British-Virgin-Islands", "🇻🇬");
        emojiRegionMapper.put("United-States-Virgin-Islands", "🇻🇮");
        emojiRegionMapper.put("󠁷󠁬󠁳󠁿Wales", "🏴󠁧󠁢");
        emojiRegionMapper.put("Wallis-and-Futuna", "🇼🇫");
        emojiRegionMapper.put("Western-Sahara", "🇪🇭");
        emojiRegionMapper.put("Yemen", "🇾🇪");
        emojiRegionMapper.put("Zambia", "🇿🇲");
        emojiRegionMapper.put("Zimbabwe", "🇿🇼");
    }

    public Mono<List<Region>> getRegionList() {
        return Mono.just(emojiRegionMapper.getListOfRegions());
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

        @Override
        public String put(String key, String value) {
            getListOfRegions().add(new Region(key, locationDecorator(key), value));
            return super.put(key.toLowerCase(), value);
        }

        // not @Override because that would require the key parameter to be of type Object
        public String get(String key) {
            return super.get(key.toLowerCase());
        }

        public List<Region> getListOfRegions() {
            return listOfRegions;
        }
    }
}
