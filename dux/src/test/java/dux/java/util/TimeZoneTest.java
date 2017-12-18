package dux.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(TimeZone.class)
public class TimeZoneTest extends AbstractTest {

	public void translationTest() {
		Map<String, String> sameAs = new HashMap<>();
		for (String l : new String[] { "", "ar", "ar_AE", "ar_BH", "ar_DZ", "ar_EG", "ar_IQ", "ar_JO", "ar_KW", "ar_LB",
				"ar_LY", "ar_MA", "ar_OM", "ar_QA", "ar_SA", "ar_SD", "ar_SY", "ar_TN", "ar_YE", "be", "be_BY", "bg",
				"bg_BG", "ca", "ca_ES", "cs", "cs_CZ", "da", "da_DK", "el", "el_CY", "el_GR", "en", "en_AU", "en_CA",
				"en_GB", "en_IN", "en_MT", "en_NZ", "en_PH", "en_SG", "en_US", "en_ZA", "et", "et_EE", "fi", "fi_FI",
				"ga", "ga_IE", "hr", "hr_HR", "hu", "hu_HU", "in", "in_ID", "is", "is_IS", "iw", "iw_IL", "lt", "lt_LT",
				"lv", "lv_LV", "mk", "mk_MK", "ms", "ms_MY", "mt", "mt_MT", "nl", "nl_BE", "nl_NL", "no", "no_NO",
				"no_NO_NY", "pl", "pl_PL", "pt", "pt_PT", "ro", "ro_RO", "ru", "ru_RU", "sk", "sk_SK", "sl", "sl_SI",
				"sq", "sq_AL", "sr", "sr_BA", "sr_BA_#Latn", "sr_CS", "sr_ME", "sr_ME_#Latn", "sr_RS", "sr_RS_#Latn",
				"sr__#Latn", "th", "th_TH", "th_TH_TH_#u-nu-thai", "tr", "tr_TR", "uk", "uk_UA", "vi", "vi_VN", "zh",
				"zh_SG" }) {
			sameAs.put(l, "");
		}
		for (String l : new String[] { "de", "de_AT", "de_CH", "de_DE", "de_GR", "de_LU" }) {
			sameAs.put(l, "de");
		}
		for (String l : new String[] { "fr", "fr_BE", "fr_CA", "fr_CH", "fr_FR", "fr_LU" }) {
			sameAs.put(l, "fr");
		}
		for (String l : new String[] { "es", "es_AR", "es_BO", "es_CL", "es_CO", "es_CR", "es_CU", "es_DO", "es_EC",
				"es_ES", "es_GT", "es_HN", "es_MX", "es_NI", "es_PA", "es_PE", "es_PR", "es_PY", "es_SV", "es_US",
				"es_UY", "es_VE" }) {
			sameAs.put(l, "es");
		}
		for (String l : new String[] { "it", "it_CH", "it_IT" }) {
			sameAs.put(l, "it");
		}
		for (String l : new String[] { "ja", "ja_JP", "ja_JP_JP_#u-ca-japanese" }) {
			sameAs.put(l, "ja");
		}
		for (String l : new String[] { "ko", "ko_KR" }) {
			sameAs.put(l, "ko");
		}
		for (String l : new String[] { "zh_HK", "zh_TW" }) {
			sameAs.put(l, "zh-tw");
		}
		sameAs.put("zh_CN", "zh-cn");
		for (String l : new String[] { "sv", "sv_SE" }) {
			sameAs.put(l, "sv");
		}
		for (String l : new String[] { "hi", "hi_IN" }) {
			sameAs.put(l, "hi");
		}
		sameAs.put("pt_BR", "pt-br");
		sameAs.put("en_IE", "en-ie");

		for (Locale locale : Locale.getAvailableLocales()) {
			for (String id : TimeZone.getAvailableIDs()) {
				TimeZone tz = TimeZone.getTimeZone(id);
				for (Integer style : new Integer[] { TimeZone.LONG, TimeZone.SHORT }) {
					for (boolean daylight : booleans) {
						String lstr = locale.toString();
						if (sameAs.containsKey(lstr)) {
							String expected = tz.getDisplayName(daylight, style,
									Locale.forLanguageTag(sameAs.get(lstr)));
							String actual = tz.getDisplayName(daylight, style, locale);
							aeq(expected, actual);
						}

					}
				}

			}
		}
	}

	@Test
	public void test() {

		TimeZone tzTimbuktu = TimeZone.getTimeZone("Africa/Timbuktu");
		TimeZone tzBissau = TimeZone.getTimeZone("Africa/Bissau");
		TimeZone tzMonrovia = TimeZone.getTimeZone("Africa/Monrovia");

		aeq(false, tzTimbuktu.useDaylightTime());
		aeq(false, tzBissau.useDaylightTime());
		aeq(false, tzMonrovia.useDaylightTime());
		aeq(0, tzTimbuktu.getRawOffset());
		aeq(0, tzBissau.getRawOffset());
		aeq(0, tzMonrovia.getRawOffset());
		aeq(false, tzTimbuktu.hasSameRules(tzBissau));
		aeq(false, tzTimbuktu.hasSameRules(tzMonrovia));
		aeq(false, tzBissau.hasSameRules(tzMonrovia));

		List<List<String>> groups = new ArrayList<>();
		for (String id : TimeZone.getAvailableIDs()) {
			if (groups.isEmpty()) {
				groups.add(new ArrayList<>(Arrays.asList(new String[] { id })));
			} else {
				TimeZone tz = TimeZone.getTimeZone(id);
				boolean groupFound = false;
				for (List<String> group : groups) {
					if (TimeZone.getTimeZone(group.get(0)).hasSameRules(tz)) {
						group.add(id);
						groupFound = true;
						break;
					}
				}
				if (!groupFound) {
					groups.add(new ArrayList<>(Arrays.asList(new String[] { id })));
				}
			}
		}
		for (List<String> group : groups) {
			Collections.sort(group);
			for (String id : group) {
				System.out.println(id + ":" + TimeZone.getTimeZone(id).getDisplayName(Locale.ROOT));
			}
			System.out.println();
		}

		if (t()) {
			return;
		}

		Map<String, List<String>> mmap = new HashMap<>();

		mmap.put("Short",
				new ArrayList<>(Arrays.asList(new String[] { "Navajo", "Cuba", "Jamaica", "Eire", "Greenwich",
						"Iceland", "Portugal", "Universal", "Zulu", "Poland", "Egypt", "Israel", "Libya", "Turkey",
						"Iran", "Hongkong", "Singapore", "Japan", "Kwajalein", "NZ", })));
		mmap.put("Weirdos", new ArrayList<>(Arrays.asList(new String[] { "PST8PDT", "MST7MDT", "CST6CDT", "EST5EDT",
				"GMT0", "W-SU", "NZ-CHAT", "GB-Eire", "GB", "NZ", })));
		mmap.put("Three",
				new ArrayList<>(Arrays.asList(new String[] { "HST", "AST", "PST", "MST", "PNT", "CST", "EST", "IET",
						"PRT", "CNT", "AGT", "BET", "GMT", "UCT", "UTC", "WET", "CET", "MET", "ECT", "EET", "ART",
						"CAT", "EAT", "NET", "PLT", "IST", "BST", "VST", "PRC", "CTT", "ROK", "JST", "ACT", "AET",
						"SST", "NST", "MIT", })));
		mmap.put("Pacific",
				new ArrayList<>(Arrays.asList(new String[] { "Pacific/Midway", "Pacific/Niue", "Pacific/Pago_Pago",
						"Pacific/Samoa", "Pacific/Honolulu", "Pacific/Johnston", "Pacific/Rarotonga", "Pacific/Tahiti",
						"Pacific/Marquesas", "Pacific/Gambier", "Pacific/Pitcairn", "Pacific/Easter",
						"Pacific/Galapagos", "Pacific/Palau", "Pacific/Chuuk", "Pacific/Guam", "Pacific/Port_Moresby",
						"Pacific/Saipan", "Pacific/Truk", "Pacific/Yap", "Pacific/Bougainville", "Pacific/Efate",
						"Pacific/Guadalcanal", "Pacific/Kosrae", "Pacific/Norfolk", "Pacific/Noumea", "Pacific/Pohnpei",
						"Pacific/Ponape", "Pacific/Auckland", "Pacific/Fiji", "Pacific/Funafuti", "Pacific/Kwajalein",
						"Pacific/Majuro", "Pacific/Nauru", "Pacific/Tarawa", "Pacific/Wake", "Pacific/Wallis",
						"Pacific/Chatham", "Pacific/Apia", "Pacific/Enderbury", "Pacific/Fakaofo", "Pacific/Tongatapu",
						"Pacific/Kiritimati", })));
		mmap.put("Australia",
				new ArrayList<>(Arrays.asList(new String[] { "Australia/West", "Australia/Eucla", "Australia/Adelaide",
						"Australia/Broken_Hill", "Australia/Darwin", "Australia/North", "Australia/South",
						"Australia/Yancowinna", "Australia/ACT", "Australia/Brisbane", "Australia/Canberra",
						"Australia/Currie", "Australia/Hobart", "Australia/Lindeman", "Australia/Melbourne",
						"Australia/NSW", "Australia/Queensland", "Australia/Sydney", "Australia/Tasmania",
						"Australia/Victoria", "Australia/LHI", "Australia/Lord_Howe", "Australia/Perth", })));
		mmap.put("Asia", new ArrayList<>(Arrays.asList(new String[] { "Asia/Chita", "Asia/Dili", "Asia/Jayapura",
				"Asia/Khandyga", "Asia/Seoul", "Asia/Tokyo", "Asia/Yakutsk", "Asia/Ust-Nera", "Asia/Vladivostok",
				"Asia/Magadan", "Asia/Sakhalin", "Asia/Srednekolymsk", "Asia/Anadyr", "Asia/Kamchatka", "Asia/Amman",
				"Asia/Beirut", "Asia/Damascus", "Asia/Gaza", "Asia/Hebron", "Asia/Jerusalem", "Asia/Nicosia",
				"Asia/Tel_Aviv", "Asia/Aden", "Asia/Baghdad", "Asia/Bahrain", "Asia/Famagusta", "Asia/Istanbul",
				"Asia/Kuwait", "Asia/Qatar", "Asia/Riyadh", "Asia/Tehran", "Asia/Baku", "Asia/Dubai", "Asia/Muscat",
				"Asia/Tbilisi", "Asia/Yerevan", "Asia/Kabul", "Asia/Aqtau", "Asia/Aqtobe", "Asia/Ashgabat",
				"Asia/Ashkhabad", "Asia/Atyrau", "Asia/Dushanbe", "Asia/Karachi", "Asia/Oral", "Asia/Samarkand",
				"Asia/Tashkent", "Asia/Yekaterinburg", "Asia/Calcutta", "Asia/Colombo", "Asia/Kolkata",
				"Asia/Kathmandu", "Asia/Katmandu", "Asia/Almaty", "Asia/Bishkek", "Asia/Dacca", "Asia/Dhaka",
				"Asia/Kashgar", "Asia/Omsk", "Asia/Qyzylorda", "Asia/Thimbu", "Asia/Thimphu", "Asia/Urumqi",
				"Asia/Rangoon", "Asia/Yangon", "Asia/Bangkok", "Asia/Barnaul", "Asia/Ho_Chi_Minh", "Asia/Hovd",
				"Asia/Jakarta", "Asia/Krasnoyarsk", "Asia/Novokuznetsk", "Asia/Novosibirsk", "Asia/Phnom_Penh",
				"Asia/Pontianak", "Asia/Saigon", "Asia/Tomsk", "Asia/Vientiane", "Asia/Brunei", "Asia/Choibalsan",
				"Asia/Chongqing", "Asia/Chungking", "Asia/Harbin", "Asia/Hong_Kong", "Asia/Irkutsk",
				"Asia/Kuala_Lumpur", "Asia/Kuching", "Asia/Macao", "Asia/Macau", "Asia/Makassar", "Asia/Manila",
				"Asia/Shanghai", "Asia/Singapore", "Asia/Taipei", "Asia/Ujung_Pandang", "Asia/Ulaanbaatar",
				"Asia/Ulan_Bator", "Asia/Pyongyang", })));
		mmap.put("Europe", new ArrayList<>(Arrays.asList(new String[] { "Europe/Dublin", "Europe/Guernsey",
				"Europe/Isle_of_Man", "Europe/Jersey", "Europe/Lisbon", "Europe/London", "Europe/Amsterdam",
				"Europe/Andorra", "Europe/Belgrade", "Europe/Berlin", "Europe/Bratislava", "Europe/Brussels",
				"Europe/Budapest", "Europe/Busingen", "Europe/Copenhagen", "Europe/Gibraltar", "Europe/Ljubljana",
				"Europe/Luxembourg", "Europe/Madrid", "Europe/Malta", "Europe/Monaco", "Europe/Oslo", "Europe/Paris",
				"Europe/Podgorica", "Europe/Prague", "Europe/Rome", "Europe/San_Marino", "Europe/Sarajevo",
				"Europe/Skopje", "Europe/Stockholm", "Europe/Tirane", "Europe/Vaduz", "Europe/Vatican", "Europe/Vienna",
				"Europe/Warsaw", "Europe/Zagreb", "Europe/Zurich", "Europe/Athens", "Europe/Bucharest",
				"Europe/Chisinau", "Europe/Helsinki", "Europe/Kaliningrad", "Europe/Kiev", "Europe/Mariehamn",
				"Europe/Nicosia", "Europe/Riga", "Europe/Sofia", "Europe/Tallinn", "Europe/Tiraspol", "Europe/Uzhgorod",
				"Europe/Vilnius", "Europe/Zaporozhye", "Europe/Istanbul", "Europe/Kirov", "Europe/Minsk",
				"Europe/Moscow", "Europe/Simferopol", "Europe/Volgograd", "Europe/Astrakhan", "Europe/Samara",
				"Europe/Saratov", "Europe/Ulyanovsk", "Europe/Belfast", })));
		mmap.put("Africa",
				new ArrayList<>(Arrays.asList(new String[] { "Africa/Bangui", "Africa/Brazzaville", "Africa/Ceuta",
						"Africa/Douala", "Africa/Kinshasa", "Africa/Lagos", "Africa/Libreville", "Africa/Luanda",
						"Africa/Malabo", "Africa/Ndjamena", "Africa/Niamey", "Africa/Porto-Novo", "Africa/Tunis",
						"Africa/Windhoek", "Africa/Blantyre", "Africa/Bujumbura", "Africa/Cairo", "Africa/Gaborone",
						"Africa/Harare", "Africa/Johannesburg", "Africa/Kigali", "Africa/Lubumbashi", "Africa/Lusaka",
						"Africa/Maputo", "Africa/Maseru", "Africa/Mbabane", "Africa/Tripoli", "Africa/Addis_Ababa",
						"Africa/Asmara", "Africa/Asmera", "Africa/Dar_es_Salaam", "Africa/Djibouti", "Africa/Juba",
						"Africa/Kampala", "Africa/Khartoum", "Africa/Mogadishu", "Africa/Nairobi", "Africa/Abidjan",
						"Africa/Accra", "Africa/Bamako", "Africa/Banjul", "Africa/Bissau", "Africa/Casablanca",
						"Africa/Conakry", "Africa/Dakar", "Africa/El_Aaiun", "Africa/Freetown", "Africa/Lome",
						"Africa/Monrovia", "Africa/Nouakchott", "Africa/Ouagadougou", "Africa/Sao_Tome",
						"Africa/Timbuktu", "Africa/Algiers", })));
		mmap.put("Atlantic",
				new ArrayList<>(Arrays.asList(new String[] { "Atlantic/Bermuda", "Atlantic/Stanley",
						"Atlantic/South_Georgia", "Atlantic/Azores", "Atlantic/Cape_Verde", "Atlantic/Canary",
						"Atlantic/Faeroe", "Atlantic/Faroe", "Atlantic/Madeira", "Atlantic/Reykjavik",
						"Atlantic/St_Helena", "Atlantic/Jan_Mayen", })));
		mmap.put("America", new ArrayList<>(Arrays.asList(new String[] { "America/Atka", "America/Anchorage",
				"America/Juneau", "America/Metlakatla", "America/Nome", "America/Sitka", "America/Yakutat",
				"America/Dawson", "America/Ensenada", "America/Los_Angeles", "America/Santa_Isabel", "America/Tijuana",
				"America/Vancouver", "America/Whitehorse", "America/Boise", "America/Cambridge_Bay",
				"America/Chihuahua", "America/Creston", "America/Dawson_Creek", "America/Denver", "America/Edmonton",
				"America/Fort_Nelson", "America/Hermosillo", "America/Inuvik", "America/Mazatlan", "America/Ojinaga",
				"America/Phoenix", "America/Shiprock", "America/Yellowknife", "America/Bahia_Banderas",
				"America/Belize", "America/Chicago", "America/Costa_Rica", "America/El_Salvador", "America/Guatemala",
				"America/Indiana/Knox", "America/Indiana/Tell_City", "America/Knox_IN", "America/Managua",
				"America/Matamoros", "America/Menominee", "America/Merida", "America/Mexico_City", "America/Monterrey",
				"America/Rainy_River", "America/Rankin_Inlet", "America/Regina", "America/Resolute",
				"America/Swift_Current", "America/Tegucigalpa", "America/Winnipeg", "America/Atikokan",
				"America/Bogota", "America/Cancun", "America/Cayman", "America/Coral_Harbour", "America/Detroit",
				"America/Eirunepe", "America/Fort_Wayne", "America/Guayaquil", "America/Havana", "America/Indianapolis",
				"America/Iqaluit", "America/Jamaica", "America/Kentucky/Louisville", "America/Kentucky/Monticello",
				"America/Lima", "America/Louisville", "America/Montreal", "America/Nassau", "America/New_York",
				"America/Nipigon", "America/Panama", "America/Pangnirtung", "America/Port-au-Prince",
				"America/Porto_Acre", "America/Rio_Branco", "America/Thunder_Bay", "America/Toronto",
				"America/Anguilla", "America/Antigua", "America/Aruba", "America/Asuncion", "America/Barbados",
				"America/Blanc-Sablon", "America/Boa_Vista", "America/Campo_Grande", "America/Caracas",
				"America/Cuiaba", "America/Curacao", "America/Dominica", "America/Glace_Bay", "America/Goose_Bay",
				"America/Grand_Turk", "America/Grenada", "America/Guadeloupe", "America/Guyana", "America/Halifax",
				"America/Kralendijk", "America/La_Paz", "America/Lower_Princes", "America/Manaus", "America/Marigot",
				"America/Martinique", "America/Moncton", "America/Montserrat", "America/Port_of_Spain",
				"America/Porto_Velho", "America/Puerto_Rico", "America/Santiago", "America/Santo_Domingo",
				"America/St_Barthelemy", "America/St_Kitts", "America/St_Lucia", "America/St_Thomas",
				"America/St_Vincent", "America/Thule", "America/Tortola", "America/Virgin", "America/St_Johns",
				"America/Araguaina", "America/Bahia", "America/Belem", "America/Buenos_Aires", "America/Catamarca",
				"America/Cayenne", "America/Cordoba", "America/Fortaleza", "America/Godthab", "America/Jujuy",
				"America/Maceio", "America/Mendoza", "America/Miquelon", "America/Montevideo", "America/Paramaribo",
				"America/Punta_Arenas", "America/Recife", "America/Rosario", "America/Santarem", "America/Sao_Paulo",
				"America/Noronha", "America/Scoresbysund", "America/Danmarkshavn", "America/Adak", })));
		mmap.put("Argentina",
				new ArrayList<>(Arrays.asList(new String[] { "America/Argentina/Buenos_Aires",
						"America/Argentina/Catamarca", "America/Argentina/ComodRivadavia", "America/Argentina/Cordoba",
						"America/Argentina/Jujuy", "America/Argentina/La_Rioja", "America/Argentina/Mendoza",
						"America/Argentina/Rio_Gallegos", "America/Argentina/Salta", "America/Argentina/San_Juan",
						"America/Argentina/San_Luis", "America/Argentina/Tucuman", "America/Argentina/Ushuaia", })));
		mmap.put("Indiana",
				new ArrayList<>(Arrays.asList(new String[] { "America/Indiana/Indianapolis", "America/Indiana/Marengo",
						"America/Indiana/Petersburg", "America/Indiana/Vevay", "America/Indiana/Vincennes",
						"America/Indiana/Winamac", })));
		mmap.put("North Dakota", new ArrayList<>(Arrays.asList(new String[] { "America/North_Dakota/Beulah",
				"America/North_Dakota/Center", "America/North_Dakota/New_Salem", })));
		mmap.put("Canada",
				new ArrayList<>(Arrays.asList(new String[] { "Canada/Yukon", "Canada/Mountain", "Canada/Central",
						"Canada/East-Saskatchewan", "Canada/Saskatchewan", "Canada/Eastern", "Canada/Atlantic",
						"Canada/Newfoundland", "Canada/Pacific", })));
		mmap.put("Mexico", new ArrayList<>(
				Arrays.asList(new String[] { "Mexico/BajaSur", "Mexico/General", "Mexico/BajaNorte", })));
		mmap.put("chile", new ArrayList<>(Arrays.asList(new String[] { "Chile/Continental", "Chile/EasterIsland", })));
		mmap.put("Brazil", new ArrayList<>(
				Arrays.asList(new String[] { "Brazil/West", "Brazil/East", "Brazil/DeNoronha", "Brazil/Acre", })));
		mmap.put("Antarctica",
				new ArrayList<>(Arrays.asList(new String[] { "Antarctica/Rothera", "Antarctica/Troll",
						"Antarctica/Syowa", "Antarctica/Mawson", "Antarctica/Vostok", "Antarctica/Davis",
						"Antarctica/DumontDUrville", "Antarctica/Casey", "Antarctica/Macquarie", "Antarctica/McMurdo",
						"Antarctica/South_Pole", "Antarctica/Palmer", })));
		mmap.put("Indian",
				new ArrayList<>(Arrays.asList(new String[] { "Indian/Comoro", "Indian/Mayotte", "Indian/Mahe",
						"Indian/Mauritius", "Indian/Reunion", "Indian/Kerguelen", "Indian/Maldives", "Indian/Chagos",
						"Indian/Cocos", "Indian/Christmas", "Indian/Antananarivo", })));
		mmap.put("Arctic", new ArrayList<>(Arrays.asList(new String[] { "Arctic/Longyearbyen", })));
		mmap.put("US",
				new ArrayList<>(Arrays.asList(new String[] { "US/Aleutian", "US/Hawaii", "US/Alaska", "US/Pacific",
						"US/Pacific-New", "US/Arizona", "US/Mountain", "US/Central", "US/Indiana-Starke",
						"US/East-Indiana", "US/Eastern", "US/Michigan", "US/Samoa", })));
		mmap.put("SystemV",
				new ArrayList<>(Arrays.asList(new String[] { "SystemV/HST10", "SystemV/YST9", "SystemV/YST9YDT",
						"SystemV/PST8", "SystemV/PST8PDT", "SystemV/MST7", "SystemV/MST7MDT", "SystemV/CST6",
						"SystemV/CST6CDT", "SystemV/EST5", "SystemV/EST5EDT", "SystemV/AST4", "SystemV/AST4ADT", })));
		mmap.put("Etc",
				new ArrayList<>(Arrays.asList(new String[] { "Etc/GMT+12", "Etc/GMT+11", "Etc/GMT+10", "Etc/GMT+9",
						"Etc/GMT+8", "Etc/GMT+7", "Etc/GMT+6", "Etc/GMT+5", "Etc/GMT+4", "Etc/GMT+3", "Etc/GMT+2",
						"Etc/GMT+1", "Etc/GMT", "Etc/GMT+0", "Etc/GMT-0", "Etc/GMT0", "Etc/Greenwich", "Etc/UCT",
						"Etc/UTC", "Etc/Universal", "Etc/Zulu", "Etc/GMT-1", "Etc/GMT-2", "Etc/GMT-3", "Etc/GMT-4",
						"Etc/GMT-5", "Etc/GMT-6", "Etc/GMT-7", "Etc/GMT-8", "Etc/GMT-9", "Etc/GMT-10", "Etc/GMT-11",
						"Etc/GMT-12", "Etc/GMT-13", "Etc/GMT-14", })));

		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String id1, String id2) {
				int r = new Integer(TimeZone.getTimeZone(id1).getRawOffset())
						.compareTo(TimeZone.getTimeZone(id2).getRawOffset());
				if (r == 0) {
					return id1.compareTo(id2);
				}
				return r;
			}
		};
		for (Entry<String, List<String>> e : mmap.entrySet()) {
			Collections.sort(e.getValue(), cmp);
			System.out.println(e.getKey());
			for (String id : e.getValue()) {
				TimeZone tz = TimeZone.getTimeZone(id);
				System.out.println(" - " + id);
				System.out.println("   - Long winter : " + tz.getDisplayName(false, TimeZone.LONG, Locale.ROOT));
				System.out.println("   - Long summer : " + tz.getDisplayName(true, TimeZone.LONG, Locale.ROOT));
				System.out.println("   - Short winter : " + tz.getDisplayName(true, TimeZone.SHORT, Locale.ROOT));
				System.out.println("   - Short summer : " + tz.getDisplayName(false, TimeZone.SHORT, Locale.ROOT));
				System.out.println("   - Raw offset : " + tz.getRawOffset());
				System.out.println("   - DST Savings : " + tz.getDSTSavings());
			}
			System.out.println();
		}

		if (t()) {
			return;
		}

		Map<String, ArrayList<String>> map = new HashMap<>();

		for (String id : TimeZone.getAvailableIDs()) {
			TimeZone tz = TimeZone.getTimeZone(id);
			String name = tz.getDisplayName(false, TimeZone.LONG, Locale.ROOT);
			if (!map.containsKey(name)) {
				map.put(name, new ArrayList<>());
			}
			map.get(name).add(id);
		}

		for (Entry<String, ArrayList<String>> e : map.entrySet()) {
			Collections.sort(e.getValue());
			System.out.print(e.getKey() + " : ");
			boolean sep = false;
			for (String v : e.getValue()) {
				if (sep) {
					System.out.print(", ");
				}
				System.out.print(v);
				sep = true;
			}
			System.out.println();
		}

		if (t()) {
			return;
		}

		Locale[] staticLocales = new Locale[] { Locale.CANADA, Locale.CANADA_FRENCH, Locale.CHINA, Locale.CHINESE,
				Locale.ENGLISH, Locale.FRANCE, Locale.FRENCH, Locale.GERMAN, Locale.GERMANY, Locale.ITALIAN,
				Locale.ITALY, Locale.JAPAN, Locale.JAPANESE, Locale.KOREA, Locale.KOREAN, Locale.SIMPLIFIED_CHINESE,
				Locale.TAIWAN, Locale.TRADITIONAL_CHINESE, Locale.UK, Locale.US };

		for (Locale l2 : Locale.getAvailableLocales()) {
			boolean found = false;
			for (Locale sl : staticLocales) {
				if (l2.equals(sl)) {
					found = true;
					break;
				}
			}
			System.out.println(groups.toString() + (found ? " *" : "") + " " + l2.getDisplayLanguage(Locale.ENGLISH)
					+ "/" + l2.getDisplayCountry(Locale.ENGLISH));
		}

		if (t()) {
			return;
		}

		Map<String, Integer> displayNames = new HashMap<>();

		for (String id : /* TimeZone.getAvailableIDs() */ new String[] { "Europe/Paris" }) {
			TimeZone tz = TimeZone.getTimeZone(id);
			for (Locale locale : Locale.getAvailableLocales()) {
				for (Integer style : new Integer[] { TimeZone.LONG/* , TimeZone.SHORT */ }) {
					for (boolean daylight : /* booleans */new boolean[] { false }) {
						String key = tz.getDisplayName(daylight, style, locale);
						if (!displayNames.containsKey(key)) {
							displayNames.put(key, 0);
						}
						displayNames.put(key, displayNames.get(key) + 1);
					}
				}
			}
		}
		for (Entry<String, Integer> e : displayNames.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}

		if (t()) {
			return;
		}
		String[] ids_ = TimeZone.getAvailableIDs();
		aeq(628, ids_.length);

		List<String> etcs = new ArrayList<>();
		List<String> continental = new ArrayList<>();
		List<String> threes = new ArrayList<>();
		List<String> simple = new ArrayList<>();

		for (String id : ids_) {
			if (id.indexOf("/") > 0) {
				if (id.startsWith("Etc/")) {
					etcs.add(id);
				} else {
					continental.add(id);
				}
			} else {
				if (id.length() == 3) {
					threes.add(id);
				} else {
					simple.add(id);
				}
			}

			System.out.println(id);
		}

		Collections.sort(etcs);
		Collections.sort(continental);
		Collections.sort(threes);
		Collections.sort(simple);

		aeq(37, threes.size());
		for (String id : threes) {
			System.out.println(id);
		}
		aeq(29, simple.size());
		for (String id : simple) {
			System.out.println(id);
		}
		aeq(35, etcs.size());
		for (String id : etcs) {
			System.out.println(id);
		}
		aeq(527, continental.size());
		for (String id : continental) {
			System.out.println(id);
		}

		TimeZone tz = TimeZone.getTimeZone("Europe/Paris");
		System.out.println(tz.getDisplayName(true, TimeZone.LONG, Locale.FRENCH));
		System.out.println(tz.getDisplayName(false, TimeZone.LONG, Locale.FRENCH));
		System.out.println(tz.getDisplayName(true, TimeZone.SHORT, Locale.FRENCH));
		System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.FRENCH));

		/*-
		getAvailableIDs()
		getAvailableIDs(int)
		getDefault()
		getTimeZone(String)
		getTimeZone(ZoneId)
		setDefault(TimeZone)
		TimeZone()
		clone()
		getDisplayName()
		getDisplayName(boolean, int)
		getDisplayName(boolean, int, Locale)
		getDisplayName(Locale)
		getDSTSavings()
		getID()
		getOffset(int, int, int, int, int, int)
		getOffset(long)
		getRawOffset()
		hasSameRules(TimeZone)
		inDaylightTime(Date)
		observesDaylightTime()
		setID(String)
		setRawOffset(int)
		toZoneId()
		useDaylightTime()
		 */
	}

	@SuppressWarnings("unused")
	private static class TZ extends TimeZone {

		private static final long serialVersionUID = 1L;

		@Override
		public int getOffset(int era, int year, int month, int day, int dayOfWeek, int milliseconds) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setRawOffset(int offsetMillis) {
			// TODO Auto-generated method stub

		}

		@Override
		public int getRawOffset() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean useDaylightTime() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean inDaylightTime(Date date) {
			// TODO Auto-generated method stub
			return false;
		}

	}
}
