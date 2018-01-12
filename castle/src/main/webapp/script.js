/*
 * declare map as a global variable
 */
var map;

/*
 * use google maps api built-in mechanism to attach dom events
 */
google.maps.event.addDomListener(window, "load", function () {

  /*
   * create map
   */
  var map = new google.maps.Map(document.getElementById("map_div"), {
    center: new google.maps.LatLng(48.866667, 2.333333),
    zoom: 14,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  });

  /*
   * create infowindow (which will be used by markers)
   */
  var infoWindow = new google.maps.InfoWindow();

  /*
   * marker creater function (acts as a closure for html parameter)
   */
  function createMarker(options, html) {
    var marker = new google.maps.Marker(options);
    if (html) {
      google.maps.event.addListener(marker, "click", function () {
        infoWindow.setContent(html);
        infoWindow.open(options.map, this);
      });
    }
    return marker;
  }

  var data = [{
		"item": "http://www.wikidata.org/entity/Q2968621",
		"itemLabel": "château de Boulogne",
		"geo": "Point(4.43979 44.6899)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968623",
		"itemLabel": "château de Bourbilly",
		"geo": "Point(4.23491 47.4551)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968624",
		"itemLabel": "château de Bourdeau",
		"geo": "Point(5.85846 45.6858)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968626",
		"itemLabel": "château de Boumois",
		"geo": "Point(-0.13 47.3083)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968627",
		"itemLabel": "château de Bourguignon-sous-Montbavin",
		"geo": "Point(3.53998 49.5283)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968629",
		"itemLabel": "château de Bourbon-l'Archambault",
		"geo": "Point(3.0585 46.5883)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968630",
		"itemLabel": "château de Bourmont",
		"geo": "Point(-1.10083 47.5447)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968632",
		"itemLabel": "château de Bournel",
		"geo": "Point(6.4163 47.4886)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968634",
		"itemLabel": "château de Boury",
		"geo": "Point(1.73917 49.24)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968638",
		"itemLabel": "château de Bourron",
		"geo": "Point(2.6961 48.3406)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968646",
		"itemLabel": "château de Boutavent",
		"geo": "Point(-2.05111111 48.07472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968647",
		"itemLabel": "château de Boves",
		"geo": "Point(2.38083 49.8433)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968649",
		"itemLabel": "château de Boyac",
		"geo": "Point(-2.38222 47.9568)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968653",
		"itemLabel": "château de Branges",
		"geo": "Point(3.50416 49.2648)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968655",
		"itemLabel": "château de Bresles",
		"geo": "Point(2.25222 49.4092)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968656",
		"itemLabel": "château de Bressey-sur-Tille",
		"geo": "Point(5.18269 47.31)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968658",
		"itemLabel": "château de Bressieux",
		"geo": "Point(5.27917 45.3225)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968661",
		"itemLabel": "château de Brandon",
		"geo": "Point(4.481388888 46.850277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968662",
		"itemLabel": "château de Briacé",
		"geo": "Point(-0.05635 47.266)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968663",
		"itemLabel": "château de Briançon",
		"geo": "Point(6.47306 45.5311)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968664",
		"itemLabel": "château de Bressuire",
		"geo": "Point(-0.498888888 46.841666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968669",
		"itemLabel": "château de Breteuil",
		"geo": "Point(2.02305556 48.68027778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968671",
		"itemLabel": "château de Bricquebec",
		"geo": "Point(-1.6325 49.470555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968673",
		"itemLabel": "château de Brienne-le-Château",
		"geo": "Point(4.52055 48.3916)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968675",
		"itemLabel": "château de Bridoire",
		"geo": "Point(0.45861111 44.76805556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968681",
		"itemLabel": "château de Brieudet"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968684",
		"itemLabel": "château de Briord",
		"geo": "Point(-1.76784 47.1599)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968685",
		"itemLabel": "château de Brissac (Hérault)",
		"geo": "Point(3.70195 43.875)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968686",
		"itemLabel": "château de Brochon",
		"geo": "Point(4.9731 47.2384)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968689",
		"itemLabel": "château de Brou",
		"geo": "Point(2.6327 48.8878)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968691",
		"itemLabel": "château de Brousse",
		"geo": "Point(2.625 43.9967)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968693",
		"itemLabel": "château de Brugheas",
		"geo": "Point(3.36603 46.0772)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968694",
		"itemLabel": "château de Brécourt",
		"geo": "Point(1.4239 49.0518)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968695",
		"itemLabel": "château de Bruzac",
		"geo": "Point(0.80305556 45.38194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968696",
		"itemLabel": "château de Brévannes",
		"geo": "Point(2.48856 48.7485)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968697",
		"itemLabel": "château de Bruyères",
		"geo": "Point(6.71777778 48.21305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968698",
		"itemLabel": "château de Bucey-en-Othe",
		"geo": "Point(3.86113 48.2634)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968701",
		"itemLabel": "château de Bucy-le-Long",
		"geo": "Point(3.40283 49.3894)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968703",
		"itemLabel": "château de Buffavent",
		"geo": "Point(6.40667 46.2881)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968704",
		"itemLabel": "château de Bugarach",
		"geo": "Point(2.35143 42.8767)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968705",
		"itemLabel": "château de Buisson-Rond",
		"geo": "Point(5.9375 45.5644)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968708",
		"itemLabel": "château de Buy",
		"geo": "Point(6.2319 49.1963)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968711",
		"itemLabel": "château de Buzancy",
		"geo": "Point(4.95389 49.4244)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968712",
		"itemLabel": "château de Bussière",
		"geo": "Point(4.197828 46.824739)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968714",
		"itemLabel": "château de Buzay",
		"geo": "Point(-1.08194 46.1267)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968715",
		"itemLabel": "château de Bélarga",
		"geo": "Point(3.485337483 43.552523868)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968716",
		"itemLabel": "château de Béhoust",
		"geo": "Point(1.72242 48.8314)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968717",
		"itemLabel": "château de Busset",
		"geo": "Point(3.51 46.06305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968718",
		"itemLabel": "château de Bény-sur-Mer",
		"geo": "Point(-0.434958 49.2882)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968720",
		"itemLabel": "château de Bénéhard",
		"geo": "Point(0.53194 47.7664)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968721",
		"itemLabel": "château de Béru",
		"geo": "Point(3.88766 47.8011)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968723",
		"itemLabel": "château de Cabrespines",
		"geo": "Point(2.71825 44.5839)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968724",
		"itemLabel": "château de Cabrières",
		"geo": "Point(3.36333 43.5781)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968726",
		"itemLabel": "château de Bénouville",
		"geo": "Point(-0.281111111 49.236111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968730",
		"itemLabel": "château de Cadillac",
		"geo": "Point(-0.3204 44.638)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968732",
		"itemLabel": "château de Cahuzac",
		"geo": "Point(1.85111 43.1897)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968733",
		"itemLabel": "château de Caillac",
		"geo": "Point(2.52667 44.9128)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968741",
		"itemLabel": "château de Calvières",
		"geo": "Point(4.1949 43.635)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968742",
		"itemLabel": "château de Calmont d'Olt",
		"geo": "Point(2.752708333 44.517947222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968746",
		"itemLabel": "château de Camboulan",
		"geo": "Point(1.92349 44.5032)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968749",
		"itemLabel": "château de Cambron",
		"geo": "Point(3.87214 49.8282)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968750",
		"itemLabel": "château de Campagne",
		"geo": "Point(6.1121 43.8203)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968751",
		"itemLabel": "château de Campan",
		"geo": "Point(2.61109 43.477)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968752",
		"itemLabel": "château de Caen",
		"geo": "Point(-0.362777777 49.186388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968754",
		"itemLabel": "château de Campbon",
		"geo": "Point(-1.96804 47.4132)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968755",
		"itemLabel": "château de Canac",
		"geo": "Point(2.53917 44.3908)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968756",
		"itemLabel": "château de Canchy",
		"geo": "Point(-0.984077 49.3302)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968758",
		"itemLabel": "château de Canet",
		"geo": "Point(3.4906 43.6017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968759",
		"itemLabel": "château de Canet-en-Roussillon",
		"geo": "Point(3.0086 42.7068)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968761",
		"itemLabel": "château de Candale",
		"geo": "Point(-0.66277778 43.68361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968763",
		"itemLabel": "château de Cantepau",
		"geo": "Point(2.16232 43.9448)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968768",
		"itemLabel": "château de Caratel",
		"geo": "Point(-1.46161 47.6696)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968774",
		"itemLabel": "château de Cas",
		"geo": "Point(1.77162 44.2)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968776",
		"itemLabel": "château de Cascastel",
		"geo": "Point(2.7589 42.986)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968777",
		"itemLabel": "château de Carbonat",
		"geo": "Point(2.4877 44.9089)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968778",
		"itemLabel": "château de Castagnac",
		"geo": "Point(1.35167 43.2322)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968780",
		"itemLabel": "château de Castelmore",
		"geo": "Point(0.157734 43.7108)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968781",
		"itemLabel": "château de Castanet",
		"geo": "Point(3.89833333 44.45027778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968782",
		"itemLabel": "château de Castelnau-Pégayrols",
		"geo": "Point(2.93252 44.1295)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968785",
		"itemLabel": "château de Castelnaudary",
		"geo": "Point(1.9589 43.3156)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968786",
		"itemLabel": "château de Castelnau-de-Lévis",
		"geo": "Point(2.08361111 43.93972222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968789",
		"itemLabel": "château de Caudeval",
		"geo": "Point(1.97405 43.0755)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968791",
		"itemLabel": "château de Castries",
		"geo": "Point(3.986930555 43.677341666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968796",
		"itemLabel": "château de Caumale",
		"geo": "Point(0.03361111 43.98333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968797",
		"itemLabel": "château de Cavanac",
		"geo": "Point(2.32689 43.1676)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968801",
		"itemLabel": "château de Caze",
		"geo": "Point(0.0397394 44.6337)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968803",
		"itemLabel": "château de Cazeneuve",
		"geo": "Point(-0.31833333 44.3875)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968805",
		"itemLabel": "château de Cellettes",
		"geo": "Point(0.14556 45.8642)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968809",
		"itemLabel": "château de Chabenet",
		"geo": "Point(1.49859 46.6249)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968811",
		"itemLabel": "château de Chabrot",
		"geo": "Point(0.5133 45.6762)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968812",
		"itemLabel": "château de Chacé",
		"geo": "Point(-0.075166 47.2138)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968815",
		"itemLabel": "château de Chacenay",
		"geo": "Point(4.52916667 48.11305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968820",
		"itemLabel": "château de Chalandry",
		"geo": "Point(3.65036 49.6778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968821",
		"itemLabel": "château de Chalencon",
		"geo": "Point(3.98316 45.2839)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968823",
		"itemLabel": "château de Challain-la-Potherie",
		"geo": "Point(-1.04405 47.635)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968825",
		"itemLabel": "château de Chamaret",
		"geo": "Point(4.8825 44.395)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968826",
		"itemLabel": "château de Chalucet",
		"geo": "Point(1.311111111 45.732222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968830",
		"itemLabel": "château de Chalmazel",
		"geo": "Point(3.851111111 45.7025)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968831",
		"itemLabel": "château de Chambly",
		"geo": "Point(3.86057 49.7278)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968832",
		"itemLabel": "château de Chambon",
		"geo": "Point(3.3985 46.1979)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968834",
		"itemLabel": "château de Chambonnet",
		"geo": "Point(3.67777 46.4961)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968835",
		"itemLabel": "château de Chamelet",
		"geo": "Point(4.51056 45.9836)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968838",
		"itemLabel": "château de Chambonneau",
		"geo": "Point(0.438333333 46.456666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968844",
		"itemLabel": "château de Champiré",
		"geo": "Point(-1.0024 47.7547)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968848",
		"itemLabel": "château de Champignolle",
		"geo": "Point(4.20932 46.7949)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968850",
		"itemLabel": "château de Champtoceaux",
		"geo": "Point(-1.27037 47.3373)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968857",
		"itemLabel": "château de Chanac",
		"geo": "Point(3.3472 44.4661)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968858",
		"itemLabel": "château de Chanoz-Châtenay",
		"geo": "Point(5.01908 46.1862)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968862",
		"itemLabel": "château de Chanteloup",
		"geo": "Point(-0.11028 47.9688)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968865",
		"itemLabel": "château de Chanzeaux",
		"geo": "Point(-0.646584 47.2651)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968866",
		"itemLabel": "château de Chantemerle",
		"geo": "Point(6.44556 45.6386)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968867",
		"itemLabel": "château de Chappes",
		"geo": "Point(3.645 46.025)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968868",
		"itemLabel": "château de Chantérac",
		"geo": "Point(0.4325 45.18166667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968871",
		"itemLabel": "Château de Charbonnières (Savoie)",
		"geo": "Point(6.31067 45.5385)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968873",
		"itemLabel": "château de Charencey",
		"geo": "Point(5.95694 47.1478)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968874",
		"itemLabel": "château de Charmont-sous-Barbuise",
		"geo": "Point(4.16927 48.4125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968879",
		"itemLabel": "château de Charnes",
		"geo": "Point(3.20703 46.5926)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968880",
		"itemLabel": "château de Chartrené",
		"geo": "Point(-0.125868 47.4912)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968881",
		"itemLabel": "château de Charuel",
		"geo": "Point(-1.459 48.504)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968882",
		"itemLabel": "château de Chassagnes",
		"geo": "Point(4.16816 44.4115)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968887",
		"itemLabel": "château de Chassy",
		"geo": "Point(4.11444 46.585)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968891",
		"itemLabel": "château de Chateaubriant",
		"geo": "Point(-0.584475 47.4479)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968892",
		"itemLabel": "château de Chatignoux",
		"geo": "Point(2.90503 46.3865)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968899",
		"itemLabel": "château de Chaumont",
		"geo": "Point(5.95794 46.0334)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968900",
		"itemLabel": "château de Chaumont",
		"geo": "Point(4.20444 46.3328)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968902",
		"itemLabel": "château de Chavagne",
		"geo": "Point(-1.53291 47.3696)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968904",
		"itemLabel": "château de Chavagneux",
		"geo": "Point(4.79745 46.1265)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968906",
		"itemLabel": "château de Chavigné",
		"geo": "Point(-0.154683 47.4241)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968907",
		"itemLabel": "château de Chavroches",
		"geo": "Point(3.58786 46.3544)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968909",
		"itemLabel": "château de Chazelet",
		"geo": "Point(1.44026 46.5077)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968910",
		"itemLabel": "château de Chazey-sur-Ain",
		"geo": "Point(5.2534 45.8957)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968911",
		"itemLabel": "château de Chazotte",
		"geo": "Point(4.65966 45.0373)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968914",
		"itemLabel": "château de Chazeu",
		"geo": "Point(4.19806 46.8972)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968916",
		"itemLabel": "château de Chenavel",
		"geo": "Point(5.38667 46.065)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968917",
		"itemLabel": "château de Chenon",
		"geo": "Point(0.24611 45.9494)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968918",
		"itemLabel": "château de Chessy",
		"geo": "Point(4.62472 45.8875)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968924",
		"itemLabel": "château de Chevigné",
		"geo": "Point(-0.710896 47.4058)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968927",
		"itemLabel": "château de Chevillon",
		"geo": "Point(3.17278 47.9222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968929",
		"itemLabel": "château de Chevreaux",
		"geo": "Point(5.40333333 46.51055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968930",
		"itemLabel": "château de Chillac",
		"geo": "Point(-0.08111 45.3647)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968931",
		"itemLabel": "château de Chilly-Mazarin",
		"geo": "Point(2.31256 48.7024)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968933",
		"itemLabel": "château de Chissey-en-Morvan",
		"geo": "Point(4.22543 47.1154)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968937",
		"itemLabel": "château de Chitenay",
		"geo": "Point(1.37737 47.4937)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968938",
		"itemLabel": "château de Chevron",
		"geo": "Point(6.33722222 45.67527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968940",
		"itemLabel": "château de Choisy",
		"geo": "Point(6.04728 45.9882)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968949",
		"itemLabel": "château de Chouvigny (Chouvigny)",
		"geo": "Point(2.99388889 46.12472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968956",
		"itemLabel": "château de Châteaubriant",
		"geo": "Point(-1.373 47.72)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968958",
		"itemLabel": "château de Châteaubrun",
		"geo": "Point(1.60333 46.4672)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968960",
		"itemLabel": "château de Châteauneuf-sur-Cher",
		"geo": "Point(2.3202 46.8586)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968963",
		"itemLabel": "château de Châteauvieux",
		"geo": "Point(6.20333 45.8289)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968964",
		"itemLabel": "château de Châteauvieux (Seynod)",
		"geo": "Point(6.08722 45.8711)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968966",
		"itemLabel": "château de Château-sur-Epte",
		"geo": "Point(1.66194444 49.19777778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968968",
		"itemLabel": "château de Châtelperron",
		"geo": "Point(3.63661 46.4)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968974",
		"itemLabel": "château de Châtillon-d'Azergues",
		"geo": "Point(4.64527778 45.87888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968975",
		"itemLabel": "château de Châtillon-sur-Chalaronne",
		"geo": "Point(4.954831 46.117881)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968976",
		"itemLabel": "château de Châtillon-sur-Cluses",
		"geo": "Point(6.58306 46.0844)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968977",
		"itemLabel": "château de Châtillon",
		"geo": "Point(5.8422 45.7997)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968979",
		"itemLabel": "château de Châtres",
		"geo": "Point(2.99253 47.7788)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968981",
		"itemLabel": "château de Chéry",
		"geo": "Point(3.47822 47.693)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968982",
		"itemLabel": "château de Cipières",
		"geo": "Point(1.27764 44.9591)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968984",
		"itemLabel": "château de Cisery",
		"geo": "Point(4.06322 47.508)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968985",
		"itemLabel": "château de Citou",
		"geo": "Point(2.54019 43.3792)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968992",
		"itemLabel": "château de Clavières",
		"geo": "Point(2.53944 44.9853)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968993",
		"itemLabel": "château de Clefs",
		"geo": "Point(-0.070137 47.6272)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968994",
		"itemLabel": "château de Clavières-Ayrens",
		"geo": "Point(2.34916667 44.98138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968995",
		"itemLabel": "château de Clermont-sur-Lauquet",
		"geo": "Point(2.42194 43.0433)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968998",
		"itemLabel": "château de Clumanc",
		"geo": "Point(6.386 44.0267)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969004",
		"itemLabel": "château de Coiselet",
		"geo": "Point(5.58751 46.2897)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969005",
		"itemLabel": "château de Colliers",
		"geo": "Point(1.51508 47.6656)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969007",
		"itemLabel": "château de Colombe-lès-Vesoul",
		"geo": "Point(6.20928 47.6125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969010",
		"itemLabel": "château de Colombier-le-Vieux",
		"geo": "Point(4.70085 45.0631)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969012",
		"itemLabel": "château de Combettes",
		"geo": "Point(3.4849 44.6957)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969014",
		"itemLabel": "château de Combettes",
		"geo": "Point(3.36396 44.6565)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969015",
		"itemLabel": "château de Comblat",
		"geo": "Point(2.60944 44.97)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969023",
		"itemLabel": "château de Condrieu",
		"geo": "Point(4.76545 45.4658)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969024",
		"itemLabel": "château de Conquereuil",
		"geo": "Point(-1.7323 47.612)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969027",
		"itemLabel": "château de Conches-en-Ouche",
		"geo": "Point(0.94333333 48.96138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969029",
		"itemLabel": "château de Corbelin",
		"geo": "Point(3.3319 47.3809)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969031",
		"itemLabel": "château de Corcelles-en-Beaujolais",
		"geo": "Point(4.71583 46.1622)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969032",
		"itemLabel": "château de Corcelles",
		"geo": "Point(4.28167 46.4539)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969034",
		"itemLabel": "château de Corcelles",
		"geo": "Point(4.7617 45.9474)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969036",
		"itemLabel": "château de Corcheval",
		"geo": "Point(4.40716 46.4215)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969039",
		"itemLabel": "château de Cordiron",
		"geo": "Point(5.7994 47.266)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969040",
		"itemLabel": "château de Cornay",
		"geo": "Point(4.94884 49.3005)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969041",
		"itemLabel": "château de Cornillon (Bugey)",
		"geo": "Point(5.43814 45.9498)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969042",
		"itemLabel": "château de Cornillon",
		"geo": "Point(6.42444 45.7103)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969045",
		"itemLabel": "château de Couffoulens",
		"geo": "Point(2.30681 43.155)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969046",
		"itemLabel": "château de Cordon",
		"geo": "Point(5.62583333 45.62083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969047",
		"itemLabel": "château de Cougoussac",
		"geo": "Point(3.38 44.5683)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969048",
		"itemLabel": "château de Cougousse",
		"geo": "Point(2.51314 44.4348)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969049",
		"itemLabel": "château de Couches",
		"geo": "Point(4.58706 46.8629)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969050",
		"itemLabel": "château de Couin",
		"geo": "Point(2.53144 50.1354)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969051",
		"itemLabel": "château de Coulaine",
		"geo": "Point(0.189632 47.1799)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969052",
		"itemLabel": "château de Coulans",
		"geo": "Point(0.02639 48.0142)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969054",
		"itemLabel": "château de Coulennes",
		"geo": "Point(-0.12972 48.0097)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969056",
		"itemLabel": "château de Cour-sur-Loire",
		"geo": "Point(1.42619 47.6501)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969060",
		"itemLabel": "château de Courtalain",
		"geo": "Point(1.13327 48.0804)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969062",
		"itemLabel": "château de Courcy",
		"geo": "Point(0.04083333 48.97111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969064",
		"itemLabel": "château de Courson",
		"geo": "Point(2.14694444 48.60027778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969069",
		"itemLabel": "château de Coupiac",
		"geo": "Point(2.581388888 43.954166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240680",
		"itemLabel": "château de Dunois",
		"geo": "Point(1.633444444 47.77775)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240685",
		"itemLabel": "château de Durtal",
		"geo": "Point(-0.244666666 47.670472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240741",
		"itemLabel": "château d'Effiat",
		"geo": "Point(3.25166667 46.04361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240956",
		"itemLabel": "château de Fayrac",
		"geo": "Point(1.14838 44.8159)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2241121",
		"itemLabel": "château de Fénelon",
		"geo": "Point(1.35033 44.84228)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2241284",
		"itemLabel": "château de Gratot",
		"geo": "Point(-1.49 49.068055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2241293",
		"itemLabel": "château Grimaldi",
		"geo": "Point(7.1455 43.6671)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2241293",
		"itemLabel": "château Grimaldi",
		"geo": "Point(7.14583333 43.66722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2241998",
		"itemLabel": "château de la Roque",
		"geo": "Point(1.06388889 44.88277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242003",
		"itemLabel": "château de La Bussière",
		"geo": "Point(2.74696389 47.74748056)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242004",
		"itemLabel": "château de la Possonnière",
		"geo": "Point(0.69194444 47.747)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242009",
		"itemLabel": "château de La Motte-Tilly",
		"geo": "Point(3.4315 48.4671)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242017",
		"itemLabel": "château de la Rochepot",
		"geo": "Point(4.68111111 46.95916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242073",
		"itemLabel": "château de Villiers-le-Mahieu",
		"geo": "Point(1.76777778 48.85777778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242110",
		"itemLabel": "château du Plessis-Macé",
		"geo": "Point(-0.675694444 47.54475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242114",
		"itemLabel": "château de Champ-de-Bataille",
		"geo": "Point(0.859166666 49.168333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242116",
		"itemLabel": "château du Verger de Seiches-sur-le-Loir",
		"geo": "Point(-0.36027778 47.59888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242322",
		"itemLabel": "château de l'Herm",
		"geo": "Point(0.95888889 45.07805556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242401",
		"itemLabel": "château de Mehun-sur-Yèvre",
		"geo": "Point(2.216666666 47.143055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242403",
		"itemLabel": "château de Meillant",
		"geo": "Point(2.5042 46.7831)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242403",
		"itemLabel": "château de Meillant",
		"geo": "Point(2.50402778 46.78333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2242766",
		"itemLabel": "château d'Ô",
		"geo": "Point(0.087530555 48.647952777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2243074",
		"itemLabel": "château de Ratilly",
		"geo": "Point(3.167222222 47.554444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2243096",
		"itemLabel": "château des Ravalet",
		"geo": "Point(-1.5667 49.6298)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2243291",
		"itemLabel": "château de Saint-Fargeau",
		"geo": "Point(3.071944444 47.639444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2243521",
		"itemLabel": "château de Simiane-la-Rotonde",
		"geo": "Point(5.56138889 43.98111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2243666",
		"itemLabel": "château de Sully",
		"geo": "Point(4.473472222 47.010833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2243758",
		"itemLabel": "château de Tournon",
		"geo": "Point(4.83175 45.068333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2244370",
		"itemLabel": "château d'Étoges",
		"geo": "Point(3.85138889 48.88180556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2244831",
		"itemLabel": "manoir de Saint-Hubert",
		"geo": "Point(2.96361111 46.43222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2247151",
		"itemLabel": "château de Rossillon",
		"geo": "Point(5.59169 45.8339)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2248518",
		"itemLabel": "château du Petit Perron",
		"geo": "Point(4.81111 45.7004)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2248951",
		"itemLabel": "château de la Motte-Glain",
		"geo": "Point(-1.19916 47.6204)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2249735",
		"itemLabel": "château des Salles",
		"geo": "Point(-3.1564 48.5583)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2252663",
		"itemLabel": "château de la Guerche",
		"geo": "Point(0.73 46.883888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2255651",
		"itemLabel": "château de Montrottier",
		"geo": "Point(6.0389 45.8986)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2259452",
		"itemLabel": "château d'Annecy",
		"geo": "Point(6.126111111 45.8975)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2260088",
		"itemLabel": "château du parc Soubise",
		"geo": "Point(-1.0871 46.8069)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2263240",
		"itemLabel": "château de Rosanbo",
		"geo": "Point(-3.552777777 48.625555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2265940",
		"itemLabel": "château d'Ardelay",
		"geo": "Point(-1.00532 46.8531)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2269885",
		"itemLabel": "château de Bellocq",
		"geo": "Point(-0.914166666 43.5175)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2270419",
		"itemLabel": "château de Sallenôves",
		"geo": "Point(5.99583 46.0111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2273387",
		"itemLabel": "château du Terral",
		"geo": "Point(2.98972 43.3)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2276937",
		"itemLabel": "château de Montaigu",
		"geo": "Point(6.2158 48.6634)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2278738",
		"itemLabel": "château de Meauce",
		"geo": "Point(3.05888 46.9026)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2283058",
		"itemLabel": "château d'Excideuil",
		"geo": "Point(1.04944444 45.33388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2283624",
		"itemLabel": "château de Sauvebœuf",
		"geo": "Point(1.19861111 45.095)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2291874",
		"itemLabel": "château de la Piscine",
		"geo": "Point(3.84142 43.6122)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2293026",
		"itemLabel": "château du Vignault",
		"geo": "Point(3.7625 46.6006)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2304441",
		"itemLabel": "château de la Grève",
		"geo": "Point(-1.21056 46.7158)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2306676",
		"itemLabel": "Vieux-château de l'Île d'Yeu",
		"geo": "Point(-2.368611111 46.699444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2328537",
		"itemLabel": "château de la Fontaine",
		"geo": "Point(4.7125 45.95027778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2333115",
		"itemLabel": "château d'Eymet",
		"geo": "Point(0.396680555 44.668563888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2342721",
		"itemLabel": "château d'Arcy",
		"geo": "Point(4.00944 46.3389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2356811",
		"itemLabel": "château royal de Collioure",
		"geo": "Point(3.084583333 42.525555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2360380",
		"itemLabel": "château de Conros",
		"geo": "Point(2.42083333 44.87916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2360459",
		"itemLabel": "château de Saint-Paul-d'Oueil",
		"geo": "Point(0.551111111 42.826944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2366170",
		"itemLabel": "château de la Pommerie",
		"geo": "Point(0.83694444 44.97444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2371103",
		"itemLabel": "château d'Oche",
		"geo": "Point(1.03194444 45.52777778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2371497",
		"itemLabel": "tour Mélusine",
		"geo": "Point(-0.7722 46.5737)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2371585",
		"itemLabel": "château de Vilmorin",
		"geo": "Point(2.26842 48.7495)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2374744",
		"itemLabel": "château de Berzé",
		"geo": "Point(4.68861 46.385)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2376119",
		"itemLabel": "château de Loisy",
		"geo": "Point(5.03014 46.5822)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2376182",
		"itemLabel": "château d'Avully",
		"geo": "Point(6.40034 46.2718)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2376692",
		"itemLabel": "château de la Lande",
		"geo": "Point(2.64831 46.5404)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2377009",
		"itemLabel": "château du Terreau",
		"geo": "Point(4.43972 46.4083)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2377402",
		"itemLabel": "château de Grandchamp",
		"geo": "Point(3.15685 47.8067)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2378450",
		"itemLabel": "château de Quintin",
		"geo": "Point(-2.9087 48.403)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2378583",
		"itemLabel": "château de Galleville",
		"geo": "Point(0.7889 49.7311)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2380768",
		"itemLabel": "château de Vouzeron",
		"geo": "Point(2.2361 47.2547)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2381083",
		"itemLabel": "château de Précy-sur-Vrin",
		"geo": "Point(3.2518 47.9672)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2381955",
		"itemLabel": "château de Ternand",
		"geo": "Point(4.52944 45.9444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2383169",
		"itemLabel": "château Bellegarde",
		"geo": "Point(-0.92055556 43.93361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2384333",
		"itemLabel": "château de Montaigut",
		"geo": "Point(2.88 43.885833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2387101",
		"itemLabel": "château de Chevannes",
		"geo": "Point(4.80083 46.5783)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2390751",
		"itemLabel": "château de la Madeleine",
		"geo": "Point(-1.02996 47.3851)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2393265",
		"itemLabel": "château du Sou",
		"geo": "Point(4.63944444 45.98138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2398623",
		"itemLabel": "château de Mesnières",
		"geo": "Point(1.38178 49.7623)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2398701",
		"itemLabel": "château du Fey",
		"geo": "Point(3.33035 48.014)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2399977",
		"itemLabel": "château de la Baronnière",
		"geo": "Point(-1.02893 47.3236)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2400209",
		"itemLabel": "château de Fumel",
		"geo": "Point(0.970556 44.4972)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2400326",
		"itemLabel": "château Mage",
		"geo": "Point(2.5134 44.5183)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2404503",
		"itemLabel": "château de Montesson",
		"geo": "Point(-0.3751 48.2521)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2404911",
		"itemLabel": "château de Saveille",
		"geo": "Point(-0.0083 46.0411)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2405390",
		"itemLabel": "château de Montrond",
		"geo": "Point(2.49555556 46.72277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2405730",
		"itemLabel": "château de Charles-Le-Téméraire",
		"geo": "Point(4.277624 46.435652)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2405910",
		"itemLabel": "château de Montdardier",
		"geo": "Point(3.5925 43.9283)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2406585",
		"itemLabel": "château de Hautvillars",
		"geo": "Point(4.603 44.86)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2408797",
		"itemLabel": "château de la Sandre",
		"geo": "Point(0.89325 45.1946)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2409187",
		"itemLabel": "château de Bouges",
		"geo": "Point(1.673055555 47.042222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2410650",
		"itemLabel": "château de Cœuvres",
		"geo": "Point(3.15443 49.3376)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2412699",
		"itemLabel": "château de Bissy-sur-Fley",
		"geo": "Point(4.62194 46.6633)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2412975",
		"itemLabel": "château de Portes",
		"geo": "Point(4.02722222 44.26805556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2413211",
		"itemLabel": "château du Pailly",
		"geo": "Point(5.4138 47.7919)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2414612",
		"itemLabel": "château de l'Épervière",
		"geo": "Point(4.94472 46.6544)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2415426",
		"itemLabel": "château du Touvet",
		"geo": "Point(5.9465 45.3634)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2415723",
		"itemLabel": "château Fougas",
		"geo": "Point(-0.54277778 45.06083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2416166",
		"itemLabel": "château de Gageac",
		"geo": "Point(0.34305556 44.79944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2418225",
		"itemLabel": "château de Vitré",
		"geo": "Point(-1.215277777 48.124444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2419969",
		"itemLabel": "château de Fourques",
		"geo": "Point(4.61222 43.6942)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969070",
		"itemLabel": "château de Coustaussa",
		"geo": "Point(2.27676 42.9402)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969073",
		"itemLabel": "château de Cramaille",
		"geo": "Point(3.45188 49.229)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969083",
		"itemLabel": "château de Croissy",
		"geo": "Point(2.152 48.8779)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969084",
		"itemLabel": "château de Cromières",
		"geo": "Point(0.83333 45.7125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969087",
		"itemLabel": "château de Cruzols",
		"geo": "Point(4.67231 45.8308)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969088",
		"itemLabel": "château de Creully",
		"geo": "Point(-0.54 49.286388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969090",
		"itemLabel": "château de Crèvecœur",
		"geo": "Point(6.5417 48.2283)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969093",
		"itemLabel": "château de Cuise",
		"geo": "Point(3.00871 49.3855)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969094",
		"itemLabel": "château de Cuire",
		"geo": "Point(4.8288 45.7942)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969100",
		"itemLabel": "château de Curton",
		"geo": "Point(-0.251111111 44.811944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969101",
		"itemLabel": "château de Cérons",
		"geo": "Point(-0.334241 44.635)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969102",
		"itemLabel": "château de Dalmayrac",
		"geo": "Point(2.6067 44.4522)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969105",
		"itemLabel": "château de Dampierre-en-Burly",
		"geo": "Point(2.5154 47.7597)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969108",
		"itemLabel": "château de Danne",
		"geo": "Point(-0.753704 47.6936)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969114",
		"itemLabel": "château de Dehault",
		"geo": "Point(0.570946 48.2082)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969115",
		"itemLabel": "château de Demigny",
		"geo": "Point(4.84139 46.9244)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969117",
		"itemLabel": "château de Dieulouard",
		"geo": "Point(6.0683 48.8427)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969123",
		"itemLabel": "château de Dinteville",
		"geo": "Point(4.8047 48.0331)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969127",
		"itemLabel": "château de Dingy",
		"geo": "Point(6.22055556 45.91083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969129",
		"itemLabel": "château de Dobert",
		"geo": "Point(-0.23528 47.8736)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969131",
		"itemLabel": "château de Diziers",
		"geo": "Point(1.46069 47.6799)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969135",
		"itemLabel": "château de Domecy-sur-Cure",
		"geo": "Point(3.79772 47.4112)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969138",
		"itemLabel": "château de Dommartin-sur-Vraine",
		"geo": "Point(5.90167 48.3364)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969140",
		"itemLabel": "château de Domfront",
		"geo": "Point(-0.6525 48.59416667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969142",
		"itemLabel": "château de Dompierre",
		"geo": "Point(1.2694 46.2181)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969143",
		"itemLabel": "château de Domeyrat",
		"geo": "Point(3.501388888 45.251388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969147",
		"itemLabel": "château de Dorches",
		"geo": "Point(5.79497 45.9966)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969153",
		"itemLabel": "château de Dracy",
		"geo": "Point(3.25194 47.7556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969154",
		"itemLabel": "château de Dracy-Saint-Loup",
		"geo": "Point(4.33463 47.0128)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969160",
		"itemLabel": "château de Droupt-Saint-Basle",
		"geo": "Point(3.93547 48.4805)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969166",
		"itemLabel": "château de Duras",
		"geo": "Point(0.178397222 44.677033333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969171",
		"itemLabel": "château de Dyo",
		"geo": "Point(4.27 46.35527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969176",
		"itemLabel": "château de Fabrègues",
		"geo": "Point(2.4628 44.948586111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969179",
		"itemLabel": "château de Falgous",
		"geo": "Point(2.8422 43.7988)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969185",
		"itemLabel": "château de Falgueyrac",
		"geo": "Point(0.90277778 44.86111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969190",
		"itemLabel": "château de Fargues",
		"geo": "Point(-0.292017 44.5335)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969191",
		"itemLabel": "château de Farcheville",
		"geo": "Point(2.28777778 48.42527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969195",
		"itemLabel": "château de Fassion"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969196",
		"itemLabel": "château de Faucigny",
		"geo": "Point(6.35796 46.1161)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969198",
		"itemLabel": "château de Faverges",
		"geo": "Point(6.2975 45.7456)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969199",
		"itemLabel": "château de Faverges-de-la-Tour",
		"geo": "Point(5.53583 45.5906)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969207",
		"itemLabel": "château de Ferrals",
		"geo": "Point(2.0751 43.3308)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969209",
		"itemLabel": "château de Ferreyroles",
		"geo": "Point(4.3586 44.2858)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969212",
		"itemLabel": "château de Ferrières",
		"geo": "Point(3.645 46.025)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969214",
		"itemLabel": "château de Ferrette",
		"geo": "Point(7.318055555 47.493333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969215",
		"itemLabel": "château de Fertans",
		"geo": "Point(6.0633 47.0511)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969217",
		"itemLabel": "château de Festieux",
		"geo": "Point(3.75382 49.5193)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969218",
		"itemLabel": "château de Fetan",
		"geo": "Point(4.74978 45.943)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969219",
		"itemLabel": "château de Fiches",
		"geo": "Point(1.66013 43.0657)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969220",
		"itemLabel": "château de Flamboin",
		"geo": "Point(3.28753 48.4704)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969221",
		"itemLabel": "château de Fitou",
		"geo": "Point(2.97741 42.8936)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969226",
		"itemLabel": "château de Fleurac",
		"geo": "Point(0.08556 45.6406)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969238",
		"itemLabel": "château de Fontariol",
		"geo": "Point(3.11569 46.3669)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969240",
		"itemLabel": "château de Fontenelle",
		"geo": "Point(6.08361 44.0382)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969243",
		"itemLabel": "château de Fontnoble",
		"geo": "Point(3.30829 46.0785)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969244",
		"itemLabel": "château de Fontorte",
		"geo": "Point(3.24411 46.1074)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969246",
		"itemLabel": "château de Fontenoy-le-Château",
		"geo": "Point(6.20027778 47.97305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969248",
		"itemLabel": "château de Fosseuse",
		"geo": "Point(2.18844 49.2097)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969249",
		"itemLabel": "château de Fougeret",
		"geo": "Point(0.674436 46.3388)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969254",
		"itemLabel": "château de Fourchaud",
		"geo": "Point(3.25579 46.4534)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969255",
		"itemLabel": "château de Fournels",
		"geo": "Point(3.12276 44.8186)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969256",
		"itemLabel": "château de Fourolles",
		"geo": "Point(3.26632 47.8007)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969259",
		"itemLabel": "château de Francheville",
		"geo": "Point(4.77015 45.7365)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969263",
		"itemLabel": "château de Frapesle",
		"geo": "Point(1.9743 46.9482)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969264",
		"itemLabel": "château de Francs",
		"geo": "Point(-0.53472222 44.80777778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969267",
		"itemLabel": "château de Franois",
		"geo": "Point(5.9247 47.2346)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969269",
		"itemLabel": "château de Fressac",
		"geo": "Point(3.91729 43.9928)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969275",
		"itemLabel": "château de Fromente",
		"geo": "Point(4.7948 45.8092)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969277",
		"itemLabel": "château de Fréteval",
		"geo": "Point(1.21149 47.8853)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969281",
		"itemLabel": "château de Frugie",
		"geo": "Point(0.99555556 45.57333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969283",
		"itemLabel": "château de Fuligny",
		"geo": "Point(4.70366 48.3308)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969290",
		"itemLabel": "château de Fère-en-Tardenois",
		"geo": "Point(3.53194444 49.22222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969291",
		"itemLabel": "château de Fésigny",
		"geo": "Point(6.17906 45.8848)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969296",
		"itemLabel": "château de Gajac",
		"geo": "Point(-0.699633 44.8853)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969300",
		"itemLabel": "château de Garde-Épée",
		"geo": "Point(-0.26028 45.6894)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969301",
		"itemLabel": "château de Gatine",
		"geo": "Point(-0.146675 47.6184)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969304",
		"itemLabel": "château de Gaujacq",
		"geo": "Point(-0.75972222 43.63277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969305",
		"itemLabel": "château de Gaussan",
		"geo": "Point(2.84222222 43.13527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969309",
		"itemLabel": "château de Genoud",
		"geo": "Point(5.26741 46.1259)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969310",
		"itemLabel": "château de Gençay",
		"geo": "Point(0.4011 46.3747)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969311",
		"itemLabel": "château de Gerbaix",
		"geo": "Point(5.73639 45.6069)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969313",
		"itemLabel": "château de Gergy",
		"geo": "Point(4.95083 46.8742)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969314",
		"itemLabel": "château de Gavaudun",
		"geo": "Point(0.888333333 44.560277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969316",
		"itemLabel": "château de Gillevoisin",
		"geo": "Point(2.23752 48.5114)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969317",
		"itemLabel": "château de Gilles de Retz",
		"geo": "Point(-1.81419 46.9914)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969320",
		"itemLabel": "château de Ginals",
		"geo": "Point(2.0064 44.4133)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969321",
		"itemLabel": "château de Gevrey-Chambertin",
		"geo": "Point(4.96555556 47.22944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969323",
		"itemLabel": "château de Givray",
		"geo": "Point(3.43586 49.2045)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969324",
		"itemLabel": "château de Girecourt-sur-Durbion",
		"geo": "Point(6.6017 48.2467)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969325",
		"itemLabel": "château de Gironville",
		"geo": "Point(-0.61722222 45.01277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969326",
		"itemLabel": "château de Gorce",
		"geo": "Point(0.49639 46.0686)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969328",
		"itemLabel": "château de Gonnord",
		"geo": "Point(-0.595516 47.2127)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969335",
		"itemLabel": "château de Gourdan",
		"geo": "Point(4.69944 45.2758)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969338",
		"itemLabel": "château de Gourdon",
		"geo": "Point(6.97833 43.72)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969344",
		"itemLabel": "château de Grand-Champ",
		"geo": "Point(2.74728 46.4161)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969345",
		"itemLabel": "château de Grandlac",
		"geo": "Point(3.32773 44.4062)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969349",
		"itemLabel": "château de Granville",
		"geo": "Point(-1.75908 47.1413)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969351",
		"itemLabel": "château de Grenod",
		"geo": "Point(4.87 46.4967)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969355",
		"itemLabel": "château de Grangent",
		"geo": "Point(4.25388889 45.46486111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969356",
		"itemLabel": "château de Grilly",
		"geo": "Point(6.11433 46.3314)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969358",
		"itemLabel": "château de Greifenstein",
		"geo": "Point(7.33416667 48.73583333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969359",
		"itemLabel": "château de Gros-Chigy",
		"geo": "Point(4.55889 46.5022)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969363",
		"itemLabel": "château de Groslée",
		"geo": "Point(5.56081 45.714)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969365",
		"itemLabel": "château de Grouchy",
		"geo": "Point(2.0613 49.0661)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969369",
		"itemLabel": "château de Gruyères",
		"geo": "Point(4.60347 49.7115)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969370",
		"itemLabel": "château de Guermange",
		"geo": "Point(6.80901 48.7943)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969374",
		"itemLabel": "château de Guilleragues",
		"geo": "Point(0.05 44.625833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969376",
		"itemLabel": "château de Générac",
		"geo": "Point(4.3484 43.7257)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969377",
		"itemLabel": "château de Gye",
		"geo": "Point(6.2461 45.7514)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969386",
		"itemLabel": "château de Hartmannswiller",
		"geo": "Point(7.21876 47.8624)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969393",
		"itemLabel": "château de Hautsegur",
		"geo": "Point(4.26694 44.6811)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969395",
		"itemLabel": "château de Hellering",
		"geo": "Point(6.78222 49.1214)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969397",
		"itemLabel": "château de Hauterive",
		"geo": "Point(-0.64944444 48.09388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969398",
		"itemLabel": "château de Hierges",
		"geo": "Point(4.74055556 50.10583333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969400",
		"itemLabel": "château de Herrenstein",
		"geo": "Point(7.39472222 48.82472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969404",
		"itemLabel": "château de Hohenstein",
		"geo": "Point(7.31055556 48.56722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969405",
		"itemLabel": "château de Huillé",
		"geo": "Point(-0.304417 47.6473)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969409",
		"itemLabel": "château de Hédé",
		"geo": "Point(-1.80521 48.2961)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969413",
		"itemLabel": "château de Jaillac",
		"geo": "Point(3.45236 48.5066)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969414",
		"itemLabel": "château de Jaligny-sur-Besbre",
		"geo": "Point(3.5915 46.3787)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969415",
		"itemLabel": "château de Janzé",
		"geo": "Point(4.73222 45.8631)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969420",
		"itemLabel": "château de Jarnioux",
		"geo": "Point(4.62694 45.9639)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969421",
		"itemLabel": "château de Jarzé",
		"geo": "Point(-0.237386 47.5545)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969422",
		"itemLabel": "château de Jasseron",
		"geo": "Point(5.3342 46.2167)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969426",
		"itemLabel": "château de Javon",
		"geo": "Point(5.34111 43.9969)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969427",
		"itemLabel": "château de Jaulny",
		"geo": "Point(5.886388888 48.969444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969430",
		"itemLabel": "château de Jaurias",
		"geo": "Point(0.41194444 45.4125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969431",
		"itemLabel": "château de Joannas",
		"geo": "Point(4.25206 44.5645)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969434",
		"itemLabel": "château de Jouaignes",
		"geo": "Point(3.53789 49.3007)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969436",
		"itemLabel": "château de Joulet",
		"geo": "Point(3.34254 46.5672)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969438",
		"itemLabel": "château de Jovelle",
		"geo": "Point(0.431806 45.3613)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969439",
		"itemLabel": "château de Jouillat",
		"geo": "Point(1.93583 46.2572)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969441",
		"itemLabel": "château de Joviac",
		"geo": "Point(4.68722 44.5675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969442",
		"itemLabel": "château de Joyeuse",
		"geo": "Point(4.24 44.4794)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969445",
		"itemLabel": "château de Juis",
		"geo": "Point(4.8508 45.985)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969446",
		"itemLabel": "château de Joyeuse Garde",
		"geo": "Point(-4.3162 48.4242)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969461",
		"itemLabel": "château de Kaysersberg",
		"geo": "Point(7.262222222 48.140277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969466",
		"itemLabel": "château de Kerampuil",
		"geo": "Point(-3.55353 48.2725)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969472",
		"itemLabel": "château de Kergrist",
		"geo": "Point(-3.43484 48.6636)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969508",
		"itemLabel": "château de Kériolet",
		"geo": "Point(-3.9081 47.8865)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969509",
		"itemLabel": "château de L'Échelle",
		"geo": "Point(4.473611111 49.800555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969510",
		"itemLabel": "château de La Berlière",
		"geo": "Point(4.9203 49.5191)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969517",
		"itemLabel": "château de La Bruyère",
		"geo": "Point(4.73616 45.9517)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969519",
		"itemLabel": "château de La Bruyère",
		"geo": "Point(-2.33973 48.2458)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969529",
		"itemLabel": "château de La Celle-Guenand",
		"geo": "Point(0.893333 46.9447)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969533",
		"itemLabel": "château de La Châtelaine",
		"geo": "Point(5.81321 46.8774)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969538",
		"itemLabel": "château de La Celle",
		"geo": "Point(2.14055556 48.85194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969548",
		"itemLabel": "château de La Forest",
		"geo": "Point(5.8075 45.6836)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969554",
		"itemLabel": "château de La Grange-Bléneau",
		"geo": "Point(2.94972222 48.66194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969556",
		"itemLabel": "château de La Grillère",
		"geo": "Point(2.17944 44.9019)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969565",
		"itemLabel": "château de La Motte",
		"geo": "Point(4.85252 45.7446)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969568",
		"itemLabel": "château de La Pomarède",
		"geo": "Point(1.95063 43.405)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969572",
		"itemLabel": "château de La Rabatelière",
		"geo": "Point(-1.25421 46.8599)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969576",
		"itemLabel": "château de La Petite-Pierre",
		"geo": "Point(7.31472222 48.85722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969579",
		"itemLabel": "château de La Roche-sur-Foron",
		"geo": "Point(6.31528 46.0658)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969580",
		"itemLabel": "château de La Roche",
		"geo": "Point(6.1919 47.4011)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969581",
		"itemLabel": "château de La Rochette",
		"geo": "Point(0.31194 45.8033)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969586",
		"itemLabel": "château de La Roche (Saint-Priest-la-Roche)",
		"geo": "Point(4.10166667 45.89583333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969587",
		"itemLabel": "château de La Serpent",
		"geo": "Point(2.1833 42.9685)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969589",
		"itemLabel": "château de La Saulaie",
		"geo": "Point(-1.04751 47.5529)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969590",
		"itemLabel": "château de La Taillée",
		"geo": "Point(-0.411719 46.395)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969592",
		"itemLabel": "château de La Tour du Pin",
		"geo": "Point(-0.16126 47.4975)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969593",
		"itemLabel": "château de La Tourette",
		"geo": "Point(4.65472 44.8739)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969598",
		"itemLabel": "château de La Vallière",
		"geo": "Point(0.885 47.4831)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969599",
		"itemLabel": "château de La Varenne",
		"geo": "Point(-1.32228 47.315)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969600",
		"itemLabel": "château de La Vigne",
		"geo": "Point(2.33028 45.1769)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969602",
		"itemLabel": "château de La Voulte",
		"geo": "Point(2.487775 45.005058333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969604",
		"itemLabel": "château de Labrit",
		"geo": "Point(-0.5413 44.0978)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969606",
		"itemLabel": "château de Labécède-Lauragais",
		"geo": "Point(2.00492 43.391)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969610",
		"itemLabel": "château de Lacoste",
		"geo": "Point(1.15589 44.7983)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969613",
		"itemLabel": "château de Lafage",
		"geo": "Point(1.861 43.175)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969614",
		"itemLabel": "château de Lafauche",
		"geo": "Point(5.4985 48.2978)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969615",
		"itemLabel": "château de Lafont",
		"geo": "Point(3.33077 46.1967)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969616",
		"itemLabel": "château de Lacaze",
		"geo": "Point(0.03416667 43.94305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969618",
		"itemLabel": "château de Lagrange-Monrepos",
		"geo": "Point(0.3211 44.1581)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969620",
		"itemLabel": "château de Lacoste",
		"geo": "Point(5.27194444 43.8325)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969622",
		"itemLabel": "château de Lalande",
		"geo": "Point(3.32278 47.6786)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969624",
		"itemLabel": "château de Lalaubie",
		"geo": "Point(2.49833 44.97)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969629",
		"itemLabel": "château de Lalinde",
		"geo": "Point(0.73805556 44.83555556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969631",
		"itemLabel": "château de Lamecourt",
		"geo": "Point(5.01337 49.6836)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969632",
		"itemLabel": "château de Laly",
		"geo": "Point(3.04944444 46.40944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969634",
		"itemLabel": "château de Lamothe",
		"geo": "Point(4.296 44.549)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969636",
		"itemLabel": "château de Lancrau",
		"geo": "Point(-0.881944 47.4219)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969637",
		"itemLabel": "château de Landal",
		"geo": "Point(-1.67523 48.491)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969641",
		"itemLabel": "château de Langlard",
		"geo": "Point(3.19253 46.1305)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969642",
		"itemLabel": "château de Langin",
		"geo": "Point(6.34356 46.2535)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969647",
		"itemLabel": "château de Landreville",
		"geo": "Point(5.008888888 49.378611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969649",
		"itemLabel": "château de Lanmary",
		"geo": "Point(0.81555556 45.24083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969651",
		"itemLabel": "château de Laprée",
		"geo": "Point(2.32472 50.6858)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969655",
		"itemLabel": "château de Largentière",
		"geo": "Point(4.291585 44.543743)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969656",
		"itemLabel": "château de Larguiès",
		"geo": "Point(2.80058 44.1938)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969658",
		"itemLabel": "château de Laréole",
		"geo": "Point(1.02389 43.7361)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969659",
		"itemLabel": "château de Lascroux",
		"geo": "Point(1.30139 46.3389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969662",
		"itemLabel": "château de Larroque-Toirac",
		"geo": "Point(1.939722222 44.521388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969663",
		"itemLabel": "château de Lascoux",
		"geo": "Point(0.4125 45.29666667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969667",
		"itemLabel": "château de Laugerie",
		"geo": "Point(1.3375 45.8264)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969668",
		"itemLabel": "château de Launaguet",
		"geo": "Point(1.45803 43.674)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969669",
		"itemLabel": "château de Latoue",
		"geo": "Point(0.7875 43.16694444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969671",
		"itemLabel": "château de Launay-Baffert",
		"geo": "Point(0.04669 47.5421)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969672",
		"itemLabel": "château de Launay",
		"geo": "Point(-1.49212 47.3289)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969673",
		"itemLabel": "château de Launac",
		"geo": "Point(1.180277777 43.743611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969677",
		"itemLabel": "château de Lavaud-Bousquet",
		"geo": "Point(1.33278 45.5633)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969680",
		"itemLabel": "château de Laurens Castelet",
		"geo": "Point(-0.49833333 43.83361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969681",
		"itemLabel": "château de Laveau",
		"geo": "Point(-0.214829 47.4762)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969686",
		"itemLabel": "château de Laye",
		"geo": "Point(4.70917 46.0244)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969687",
		"itemLabel": "château de Layé",
		"geo": "Point(4.76194 46.2697)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969688",
		"itemLabel": "château de Lavison",
		"geo": "Point(-0.02888889 44.61916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969692",
		"itemLabel": "château de Lavoûte-Polignac",
		"geo": "Point(3.89435 45.1176)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969694",
		"itemLabel": "château de Lescure",
		"geo": "Point(2.80772 44.9446)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969695",
		"itemLabel": "château de Lesquiffiou",
		"geo": "Point(-3.84026 48.5441)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969697",
		"itemLabel": "château de Leuc",
		"geo": "Point(2.32167 43.1472)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969699",
		"itemLabel": "château de Levaré",
		"geo": "Point(-0.9092 48.415)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969702",
		"itemLabel": "château de Leymarie",
		"geo": "Point(1.14528 45.7689)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969704",
		"itemLabel": "château de Levesville",
		"geo": "Point(1.43277778 48.49)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969706",
		"itemLabel": "château de Leynes",
		"geo": "Point(4.72666667 46.27)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969708",
		"itemLabel": "château de Lignou",
		"geo": "Point(-0.336306 48.6731)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969716",
		"itemLabel": "château de Lislefort",
		"geo": "Point(-0.421139 44.8017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969718",
		"itemLabel": "château de Lobit",
		"geo": "Point(-0.46194444 43.7925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969729",
		"itemLabel": "château de Longes",
		"geo": "Point(4.9762 46.1851)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969731",
		"itemLabel": "château de Looze",
		"geo": "Point(3.43724 47.9948)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969736",
		"itemLabel": "château de Losmonerie",
		"geo": "Point(1.1278 45.8189)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969737",
		"itemLabel": "château de Loriol",
		"geo": "Point(5.04 46.27888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969739",
		"itemLabel": "château de Loubressay",
		"geo": "Point(0.61306 46.6164)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969741",
		"itemLabel": "château de Loupiac",
		"geo": "Point(3.01821 44.3435)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969742",
		"itemLabel": "château de Lourdon",
		"geo": "Point(4.64667 46.4606)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969744",
		"itemLabel": "château de Louâtre",
		"geo": "Point(3.24722 49.2575)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969747",
		"itemLabel": "château de Loyes",
		"geo": "Point(5.23067 45.9267)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969750",
		"itemLabel": "château de Lucé",
		"geo": "Point(0.46861 47.8642)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969751",
		"itemLabel": "château de Lugans",
		"geo": "Point(2.88991 44.3676)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969753",
		"itemLabel": "château de Lumes",
		"geo": "Point(4.78444 49.7344)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969754",
		"itemLabel": "château de Lupé",
		"geo": "Point(4.70734 45.3739)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969756",
		"itemLabel": "château de Lugny",
		"geo": "Point(4.8075 46.4725)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969761",
		"itemLabel": "château de Lux",
		"geo": "Point(5.21183 47.4921)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969764",
		"itemLabel": "château de Léray",
		"geo": "Point(0.245 46.1417)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969767",
		"itemLabel": "château de Madic",
		"geo": "Point(2.4556 45.3828)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969768",
		"itemLabel": "château de Madirac",
		"geo": "Point(0.474524 43.9853)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969773",
		"itemLabel": "château de Maisonseule",
		"geo": "Point(4.56343 44.9509)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969777",
		"itemLabel": "château de Malicorne-sur-Sarthe",
		"geo": "Point(-0.09056 47.8133)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969778",
		"itemLabel": "château de Maligny",
		"geo": "Point(3.76179 47.8699)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969780",
		"itemLabel": "château de Malherbes",
		"geo": "Point(-0.49416667 44.8)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969789",
		"itemLabel": "château de Mantelon",
		"geo": "Point(-0.62901 47.3741)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969790",
		"itemLabel": "château de Marcilly-la-Gueurce",
		"geo": "Point(4.29389 46.3919)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969791",
		"itemLabel": "château de Marcilly",
		"geo": "Point(3.70132 47.2151)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969792",
		"itemLabel": "château de Marcilly-sur-Maulne",
		"geo": "Point(0.234 47.5497)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969793",
		"itemLabel": "château de Marconnay",
		"geo": "Point(-0.014194 46.518)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969794",
		"itemLabel": "château de Marbeaumont",
		"geo": "Point(5.17169 48.7738)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969795",
		"itemLabel": "château de Marcq",
		"geo": "Point(4.92683 49.3196)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969797",
		"itemLabel": "château de Mareste",
		"geo": "Point(5.01262 46.4304)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969799",
		"itemLabel": "château de Mareuil",
		"geo": "Point(4.0382 49.0448)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969800",
		"itemLabel": "château de Marfontaine",
		"geo": "Point(3.77354 49.8004)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969801",
		"itemLabel": "château de Marignane",
		"geo": "Point(5.21472 43.4169)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969802",
		"itemLabel": "château de Mareuil",
		"geo": "Point(0.45111111 45.45388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969804",
		"itemLabel": "château de Marigny-en-Orxois",
		"geo": "Point(3.22463 49.0615)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969805",
		"itemLabel": "château de Marigny",
		"geo": "Point(4.87667 46.4439)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969806",
		"itemLabel": "château de Marigny",
		"geo": "Point(4.45796 46.6716)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969807",
		"itemLabel": "château de Marines",
		"geo": "Point(1.98 49.1431)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969808",
		"itemLabel": "château de Marinesque",
		"geo": "Point(2.0948 44.4979)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969809",
		"itemLabel": "château de Marizy-Saint-Mard",
		"geo": "Point(3.2241 49.1797)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969810",
		"itemLabel": "château de Marnay",
		"geo": "Point(5.77217 47.2898)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969813",
		"itemLabel": "château de Marquein",
		"geo": "Point(1.73308 43.3018)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969817",
		"itemLabel": "château de Marqueyssac",
		"geo": "Point(1.16281 44.8238)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969818",
		"itemLabel": "château de Marson",
		"geo": "Point(-0.146011 47.2515)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969819",
		"itemLabel": "château de Marsay",
		"geo": "Point(-0.16148 46.9448)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969820",
		"itemLabel": "château de Martainville",
		"geo": "Point(1.29374 49.4585)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969821",
		"itemLabel": "château de Martigny-le-Comte",
		"geo": "Point(4.33208 46.5305)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969822",
		"itemLabel": "château de Martigné",
		"geo": "Point(-0.25278 47.9397)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969824",
		"itemLabel": "château de Martigné-Briand",
		"geo": "Point(-0.429937 47.2324)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969826",
		"itemLabel": "château de Mas Rougier",
		"geo": "Point(2.94471 44.0005)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969827",
		"itemLabel": "château de Masse",
		"geo": "Point(2.78626 44.5396)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969829",
		"itemLabel": "château de Massenon",
		"geo": "Point(2.03722 46.0614)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969830",
		"itemLabel": "château de Masseuil",
		"geo": "Point(0.213 46.6263)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q628375",
		"itemLabel": "château de Puivert",
		"geo": "Point(2.055 42.921111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q628389",
		"itemLabel": "château de Durban",
		"geo": "Point(2.815555555 42.994444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q628587",
		"itemLabel": "château de Rognac",
		"geo": "Point(0.82111111 45.19861111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q637019",
		"itemLabel": "château d'Anjony",
		"geo": "Point(2.48027778 45.05444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q638089",
		"itemLabel": "château de Plessis-lès-Tours",
		"geo": "Point(0.660555555 47.382777777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q639057",
		"itemLabel": "château de Condé",
		"geo": "Point(3.559444444 49.005555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q647301",
		"itemLabel": "château de Chatenet",
		"geo": "Point(-0.75222 45.6647)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q647668",
		"itemLabel": "château Lagrézette",
		"geo": "Point(1.3639 44.4878)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q654569",
		"itemLabel": "château de Montreuil-Bellay",
		"geo": "Point(-0.154166666 47.133333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q657892",
		"itemLabel": "château du Lude",
		"geo": "Point(0.158889 47.6475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q663673",
		"itemLabel": "château de Vincennes",
		"geo": "Point(2.435833333 48.842777777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q665265",
		"itemLabel": "château d'Ambleville",
		"geo": "Point(1.696389 49.150556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q667763",
		"itemLabel": "château de Quéribus",
		"geo": "Point(2.621666666 42.836666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q671459",
		"itemLabel": "château du Falkenstein",
		"geo": "Point(7.56541667 49.00486111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q678270",
		"itemLabel": "château de Caumont",
		"geo": "Point(0.9667 43.5333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q688665",
		"itemLabel": "château du Frankenbourg",
		"geo": "Point(7.325 48.29527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q691089",
		"itemLabel": "château du Bernstein",
		"geo": "Point(7.399722222 48.321944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q724929",
		"itemLabel": "château de Fougères",
		"geo": "Point(-1.209444 48.3536)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q740250",
		"itemLabel": "château de Tarascon",
		"geo": "Point(4.65503 43.8066)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q740652",
		"itemLabel": "château de Niort-de-Sault",
		"geo": "Point(2.00388889 42.80333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q741450",
		"itemLabel": "château de La Bourdaisière",
		"geo": "Point(0.838611111 47.37)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q747306",
		"itemLabel": "Fort-la-Latte",
		"geo": "Point(-2.284444 48.668333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q761920",
		"itemLabel": "château de Gien",
		"geo": "Point(2.63186932 47.68471904)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q769303",
		"itemLabel": "château du Rivau",
		"geo": "Point(0.323333 47.103889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q769365",
		"itemLabel": "château de Montpoupon",
		"geo": "Point(1.141111111 47.253055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q773139",
		"itemLabel": "château de Frontenay",
		"geo": "Point(5.6183 46.7858)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q773649",
		"itemLabel": "château de Monbazillac",
		"geo": "Point(0.494166666 44.796666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q778084",
		"itemLabel": "château de Beaufort",
		"geo": "Point(2.75889 43.2992)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q780028",
		"itemLabel": "château de Luynes",
		"geo": "Point(0.5535 47.3865)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q785341",
		"itemLabel": "château des Linières",
		"geo": "Point(-0.40194 47.9436)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q786075",
		"itemLabel": "château de Brissac",
		"geo": "Point(-0.449722222 47.353055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q787703",
		"itemLabel": "château de Budos",
		"geo": "Point(-0.382777777 44.538611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q835740",
		"itemLabel": "château de Pierre-Percée",
		"geo": "Point(6.930277777 48.470277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q839242",
		"itemLabel": "château du Hohlandsbourg",
		"geo": "Point(7.26916667 48.06)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q841527",
		"itemLabel": "château de Tiffauges",
		"geo": "Point(-1.114722222 47.016666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q842895",
		"itemLabel": "château de Kintzheim",
		"geo": "Point(7.386666666 48.256388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q842932",
		"itemLabel": "château de l'Ortenbourg",
		"geo": "Point(7.39208056 48.29573056)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q849528",
		"itemLabel": "château d'Andlau",
		"geo": "Point(7.4125 48.401388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q866181",
		"itemLabel": "château épiscopal de Lauterbourg",
		"geo": "Point(8.17678 48.9749)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q897692",
		"itemLabel": "château de Brancion",
		"geo": "Point(4.7967 46.5475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q910240",
		"itemLabel": "château de Montsabert",
		"geo": "Point(-0.34388889 47.37583333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q911574",
		"itemLabel": "château de Chazeron",
		"geo": "Point(3.03558333 45.92244444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q912447",
		"itemLabel": "château de Chinon",
		"geo": "Point(0.236111111 47.168055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q921334",
		"itemLabel": "château de Venzac",
		"geo": "Point(2.66417 44.8669)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q924311",
		"itemLabel": "château de Lorge",
		"geo": "Point(-2.8275 48.3386)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q928663",
		"itemLabel": "château de La Chapelle-Faucher",
		"geo": "Point(0.75111111 45.36944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q943636",
		"itemLabel": "château de Fondat",
		"geo": "Point(-0.2 43.984722)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q944597",
		"itemLabel": "château de Peyrepertuse",
		"geo": "Point(2.557222 42.870556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q947416",
		"itemLabel": "château du Morimont",
		"geo": "Point(7.214166666 47.445277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q947479",
		"itemLabel": "château de Chantemille",
		"geo": "Point(2.0417 46.1103)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q947645",
		"itemLabel": "château de Montrichard",
		"geo": "Point(1.186111111 47.343611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q947669",
		"itemLabel": "château du Moulin",
		"geo": "Point(1.60930556 47.36952778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q948136",
		"itemLabel": "château de Rambures",
		"geo": "Point(1.7074 49.9444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q949411",
		"itemLabel": "château de Grézan Centre Art & Culture",
		"geo": "Point(3.194430555 43.504497222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q949543",
		"itemLabel": "château de Fleury-la-Forêt",
		"geo": "Point(1.5462 49.4139)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q950048",
		"itemLabel": "château de Billy",
		"geo": "Point(3.428611111 46.236666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q950709",
		"itemLabel": "château de Sarzay",
		"geo": "Point(1.906666666 46.600416666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q952229",
		"itemLabel": "château d'Ermenonville",
		"geo": "Point(2.693055555 49.126666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q954287",
		"itemLabel": "château de la Valouze",
		"geo": "Point(0.00444444 45.14166667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q961377",
		"itemLabel": "château Lescombes",
		"geo": "Point(-0.65361111 44.88083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q966058",
		"itemLabel": "château de Castelnou",
		"geo": "Point(2.70277778 42.61888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q971529",
		"itemLabel": "château de Libouriac",
		"geo": "Point(3.21899 43.3476)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q971673",
		"itemLabel": "Q971673",
		"geo": "Point(0.34111111 46.59055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q975321",
		"itemLabel": "château de Fayolle",
		"geo": "Point(0.49972222 45.22916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q976038",
		"itemLabel": "château de Montgeoffroy",
		"geo": "Point(-0.276389 47.468889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q976230",
		"itemLabel": "château de Montfaucon",
		"geo": "Point(6.0784 47.2462)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q979709",
		"itemLabel": "château du Grand Perron",
		"geo": "Point(4.80951 45.6997)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q992215",
		"itemLabel": "château du Landskron",
		"geo": "Point(7.490555555 47.488055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1010703",
		"itemLabel": "château d'Aguilar",
		"geo": "Point(2.746944444 42.890555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1010879",
		"itemLabel": "château d'Arques",
		"geo": "Point(2.36694444 42.95305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011026",
		"itemLabel": "château de Beynac",
		"geo": "Point(1.146667 44.840556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011058",
		"itemLabel": "château de Blandy-les-Tours",
		"geo": "Point(2.7814 48.56715)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011203",
		"itemLabel": "château de Brie-Comte-Robert",
		"geo": "Point(2.6108 48.6925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011211",
		"itemLabel": "château de Brosse",
		"geo": "Point(1.32027778 46.41527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969835",
		"itemLabel": "château de Matha",
		"geo": "Point(-0.322222 45.8653)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969837",
		"itemLabel": "château de Matval",
		"geo": "Point(0.7472 47.8136)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969839",
		"itemLabel": "château de Maudétour",
		"geo": "Point(1.776388888 49.098888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969840",
		"itemLabel": "château de Maulevrier",
		"geo": "Point(3.99009 46.2072)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969842",
		"itemLabel": "château de Mauregny-en-Haye",
		"geo": "Point(3.79806 49.5294)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969843",
		"itemLabel": "château de Mauléon",
		"geo": "Point(-0.886388 43.2192)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969844",
		"itemLabel": "château de Maurepart",
		"geo": "Point(-0.362082 47.2198)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969849",
		"itemLabel": "château de Mausson",
		"geo": "Point(-1.0626 48.4491)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969851",
		"itemLabel": "château de Mauvières",
		"geo": "Point(2.01851 48.7021)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969852",
		"itemLabel": "château de Mayenne",
		"geo": "Point(-0.6181 48.3028)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969854",
		"itemLabel": "château de Mazancourt",
		"geo": "Point(3.09956 49.3009)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969855",
		"itemLabel": "château de Mazières",
		"geo": "Point(1.57826 46.6356)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969856",
		"itemLabel": "château de Maÿtie",
		"geo": "Point(-0.890556 43.2197)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969857",
		"itemLabel": "château de Meillonnas",
		"geo": "Point(5.35132 46.244)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969863",
		"itemLabel": "château de Mercuès",
		"geo": "Point(1.3953 44.4964)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969865",
		"itemLabel": "château de Mauvezin",
		"geo": "Point(0.276388888 43.118611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969868",
		"itemLabel": "château de Merpins",
		"geo": "Point(-0.39583 45.6764)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969869",
		"itemLabel": "château de Merville",
		"geo": "Point(1.30111 43.7192)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969871",
		"itemLabel": "château de Mesmont",
		"geo": "Point(4.39912 49.6131)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969872",
		"itemLabel": "château de Messac",
		"geo": "Point(2.19278 44.9714)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969873",
		"itemLabel": "château de Messei",
		"geo": "Point(-0.540359 48.7057)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969875",
		"itemLabel": "château de Messey-sur-Grosne",
		"geo": "Point(4.7425 46.6433)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969876",
		"itemLabel": "château de Messilhac",
		"geo": "Point(2.63333 44.8742)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969882",
		"itemLabel": "château de Meung-sur-Loire",
		"geo": "Point(1.69434071 47.82337014)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969883",
		"itemLabel": "château de Millemont",
		"geo": "Point(1.73867 48.8075)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969884",
		"itemLabel": "château de Milly",
		"geo": "Point(4.69739 46.3492)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969887",
		"itemLabel": "château de Milly-la-Forêt",
		"geo": "Point(2.46384 48.40213)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969889",
		"itemLabel": "château de Milly-le-Meugon",
		"geo": "Point(-0.253254 47.2867)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969890",
		"itemLabel": "château de Miglos",
		"geo": "Point(1.59056 42.7967)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969894",
		"itemLabel": "château de Miral",
		"geo": "Point(3.641111111 44.356111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969896",
		"itemLabel": "château de Miolans",
		"geo": "Point(6.186388888 45.58)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969897",
		"itemLabel": "château de Miramont",
		"geo": "Point(2.50036 43.17099)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969898",
		"itemLabel": "château de Mirebeau",
		"geo": "Point(3.29481 46.624)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969899",
		"itemLabel": "château de Mirebel",
		"geo": "Point(5.73472 46.7011)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969903",
		"itemLabel": "château de Miremont",
		"geo": "Point(2.70461 45.9019)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969904",
		"itemLabel": "château de Miribel",
		"geo": "Point(4.94903 45.8292)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969911",
		"itemLabel": "château de Molleville",
		"geo": "Point(1.83528 43.3114)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969914",
		"itemLabel": "château de Monbouan",
		"geo": "Point(-1.36206 48.0221)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969916",
		"itemLabel": "château de Monceau",
		"geo": "Point(4.7425 46.3392)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969920",
		"itemLabel": "château de Monceaux",
		"geo": "Point(2.00444 49.5198)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969921",
		"itemLabel": "château de Monismes",
		"geo": "Point(1.3175 46.0689)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969927",
		"itemLabel": "château de Monsec",
		"geo": "Point(1.01658 44.8516)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969928",
		"itemLabel": "château de Mont-Saint-Martin",
		"geo": "Point(3.6397 49.2821)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969929",
		"itemLabel": "château de Mont-de-Jeux",
		"geo": "Point(4.6399 49.495)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969932",
		"itemLabel": "château de Montaigu-le-Blin",
		"geo": "Point(3.51333 46.2964)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969933",
		"itemLabel": "château de Montaigu (Saône-et-Loire)",
		"geo": "Point(4.7125 46.8247)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969934",
		"itemLabel": "château de Mongenan",
		"geo": "Point(-0.430833333 44.696111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969935",
		"itemLabel": "château de Montaiguët-en-Forez",
		"geo": "Point(3.80189 46.2694)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969937",
		"itemLabel": "château de Montagu",
		"geo": "Point(2.22083 48.6458)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969939",
		"itemLabel": "château de Montal",
		"geo": "Point(1.86844 44.86039)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969942",
		"itemLabel": "château de Montalet",
		"geo": "Point(4.17229 44.2659)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969943",
		"itemLabel": "château de Montalègre",
		"geo": "Point(2.9361 43.8929)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969946",
		"itemLabel": "château de Montardy",
		"geo": "Point(0.442583 45.2916)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969948",
		"itemLabel": "château de Montarnal",
		"geo": "Point(2.4857 44.6057)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969952",
		"itemLabel": "château de Montbard",
		"geo": "Point(4.33507 47.6269)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969953",
		"itemLabel": "château de Montastruc",
		"geo": "Point(0.59 44.89694444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969957",
		"itemLabel": "château de Montbriand",
		"geo": "Point(4.7645 46.0434)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969958",
		"itemLabel": "château de Montbillon",
		"geo": "Point(3.01194444 46.42055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969961",
		"itemLabel": "château de Montaner",
		"geo": "Point(-0.0125 43.349166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969962",
		"itemLabel": "château de Montby",
		"geo": "Point(6.44314 47.4387)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969963",
		"itemLabel": "château de Montbron",
		"geo": "Point(0.4971 45.6679)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969964",
		"itemLabel": "château de Montbron (Landes)",
		"geo": "Point(-1.1691 44.395)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969965",
		"itemLabel": "château de Montcalm",
		"geo": "Point(4.2594 43.7407)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969970",
		"itemLabel": "château de Montchenin",
		"geo": "Point(3.369 46.4907)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969972",
		"itemLabel": "château de Montbéliard",
		"geo": "Point(6.801111111 47.509444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969975",
		"itemLabel": "château de Montcléra",
		"geo": "Point(1.21127 44.6189)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969976",
		"itemLabel": "château de Montcoy",
		"geo": "Point(4.99278 46.7942)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969977",
		"itemLabel": "château de Montcigoux",
		"geo": "Point(1.00138889 45.60611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969979",
		"itemLabel": "château de Montecler",
		"geo": "Point(-0.429722 48.1269)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969983",
		"itemLabel": "château de Montcornet",
		"geo": "Point(4.6275 49.829444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969984",
		"itemLabel": "château de Montertreau",
		"geo": "Point(0.1303 47.8474)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969986",
		"itemLabel": "château de Montespieu",
		"geo": "Point(2.22229 43.5551)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969987",
		"itemLabel": "château de Montfalcon",
		"geo": "Point(5.92012 45.772)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969989",
		"itemLabel": "château de Montfand",
		"geo": "Point(3.24964 46.3158)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969992",
		"itemLabel": "château de Montferrand-le-Château",
		"geo": "Point(5.92658 47.1746)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969993",
		"itemLabel": "château de Montferrand (Hérault)",
		"geo": "Point(3.84 43.7756)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969994",
		"itemLabel": "château de Montferrand",
		"geo": "Point(5.34604 45.9039)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2969998",
		"itemLabel": "château de Montfort-sur-Risle",
		"geo": "Point(0.67815 49.2759)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970000",
		"itemLabel": "château de Monthelie",
		"geo": "Point(4.76639 46.9912)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970001",
		"itemLabel": "château de Montguyon",
		"geo": "Point(-0.18833 45.2161)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970003",
		"itemLabel": "château de Monthelon",
		"geo": "Point(4.22624 46.9609)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970004",
		"itemLabel": "château de Montgobert",
		"geo": "Point(3.144169444 49.30985)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970009",
		"itemLabel": "château de Montivert",
		"geo": "Point(4.39479 45.1268)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970010",
		"itemLabel": "château de Montigny",
		"geo": "Point(3.13716 47.8529)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970011",
		"itemLabel": "château de Montivert",
		"geo": "Point(-0.151617 47.524)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970019",
		"itemLabel": "château de Montmaur",
		"geo": "Point(1.84502 43.3932)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970020",
		"itemLabel": "château de Montmayeur",
		"geo": "Point(6.12381 45.4899)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970021",
		"itemLabel": "château de Montlhéry",
		"geo": "Point(2.2725 48.635)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970024",
		"itemLabel": "château de Montmoreau",
		"geo": "Point(0.12917 45.4)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970026",
		"itemLabel": "château de Montmuran",
		"geo": "Point(-1.86102 48.2934)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970027",
		"itemLabel": "château de Montmusard",
		"geo": "Point(5.05936 47.3246)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970029",
		"itemLabel": "château de Montméry",
		"geo": "Point(1.39194 45.9706)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970031",
		"itemLabel": "château de Montmort",
		"geo": "Point(3.81083333 48.92333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970034",
		"itemLabel": "château de Montplaisant",
		"geo": "Point(5.2938 46.1724)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970038",
		"itemLabel": "château de Montribloud",
		"geo": "Point(4.91444444 45.91694444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970041",
		"itemLabel": "château de Montricoux",
		"geo": "Point(1.62028 44.0767)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970042",
		"itemLabel": "château de Montriou",
		"geo": "Point(-0.594608 47.6122)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970043",
		"itemLabel": "château de Montrognon",
		"geo": "Point(3.07939 45.7309)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970046",
		"itemLabel": "château de Montrond",
		"geo": "Point(4.23138889 45.64388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970047",
		"itemLabel": "château de Montrozier",
		"geo": "Point(2.74602 44.4061)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971672",
		"itemLabel": "château du Croisillat",
		"geo": "Point(1.75833 43.5311)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971673",
		"itemLabel": "château du Coudray-Salbart",
		"geo": "Point(-0.426388888 46.406944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971674",
		"itemLabel": "château du Douhet",
		"geo": "Point(-0.566667 45.8214)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971675",
		"itemLabel": "château du Cros",
		"geo": "Point(-0.296333 44.6112)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971676",
		"itemLabel": "château du Fayet",
		"geo": "Point(5.97222 45.4175)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971677",
		"itemLabel": "château du Fayel",
		"geo": "Point(2.6969 49.3699)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971679",
		"itemLabel": "château du Fort",
		"geo": "Point(3.6533 44.875)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971680",
		"itemLabel": "château du Fort-des-Salles",
		"geo": "Point(0.29111 47.7586)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971681",
		"itemLabel": "château du Fort",
		"geo": "Point(3.19422 47.7009)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971682",
		"itemLabel": "château du Fou",
		"geo": "Point(0.5094 46.72)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971683",
		"itemLabel": "château du Fresne",
		"geo": "Point(0.076051 47.5071)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971686",
		"itemLabel": "château du Goust",
		"geo": "Point(-1.8613 47.3136)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971690",
		"itemLabel": "château du Freudeneck",
		"geo": "Point(7.32777778 48.62527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971691",
		"itemLabel": "château du Grand-Riou",
		"geo": "Point(-0.448294 47.2078)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971692",
		"itemLabel": "château du Grand-Besse",
		"geo": "Point(2.27166667 46.57055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971693",
		"itemLabel": "château du Grand-Saint-Jean",
		"geo": "Point(5.37265 43.6029)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971695",
		"itemLabel": "château du Grand Coudray",
		"geo": "Point(2.97586 46.3769)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971696",
		"itemLabel": "château du Grand-Geroldseck",
		"geo": "Point(7.33222222 48.71888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971698",
		"itemLabel": "château du Grand-Ringelstein",
		"geo": "Point(7.32111111 48.56305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971701",
		"itemLabel": "château du Grand Saint-Mars",
		"geo": "Point(2.0675 48.4256)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971702",
		"itemLabel": "château du Grand Jardin",
		"geo": "Point(5.14055556 48.44638889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971704",
		"itemLabel": "château du Gô",
		"geo": "Point(2.16186 43.9503)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971710",
		"itemLabel": "château du Guildo",
		"geo": "Point(-2.20658 48.5746)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971711",
		"itemLabel": "château du Hallier",
		"geo": "Point(2.31166667 48.01694444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971713",
		"itemLabel": "château du Haut-Rasné",
		"geo": "Point(0.52083 47.7467)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971715",
		"itemLabel": "château du Hagelschloss",
		"geo": "Point(7.38944444 48.44944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971716",
		"itemLabel": "château du Hamel",
		"geo": "Point(-0.15694444 44.56277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971721",
		"itemLabel": "ferme du Maipas",
		"geo": "Point(4.36871 49.7864)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971722",
		"itemLabel": "château du Kagenfels",
		"geo": "Point(7.36638889 48.445)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971724",
		"itemLabel": "château du Loumaing",
		"geo": "Point(-0.80111111 43.71944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971725",
		"itemLabel": "château du Lieu-Dieu",
		"geo": "Point(0.77388889 45.16277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971726",
		"itemLabel": "château du Manais",
		"geo": "Point(1.75888889 49.48583333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971727",
		"itemLabel": "château du Marchidial",
		"geo": "Point(3.12626 45.5864)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971728",
		"itemLabel": "château du Mas",
		"geo": "Point(2.51164 46.254)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971730",
		"itemLabel": "château du Mas de l'Age",
		"geo": "Point(1.24583 45.8583)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971731",
		"itemLabel": "château du Meux",
		"geo": "Point(2.7463 49.3659)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971734",
		"itemLabel": "château du Marais",
		"geo": "Point(2.10224 48.5733)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971736",
		"itemLabel": "château du Monastier-sur-Gazeille",
		"geo": "Point(3.9956 44.9399)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971737",
		"itemLabel": "château du Monay",
		"geo": "Point(4.43083 46.72)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971738",
		"itemLabel": "château du Mirail",
		"geo": "Point(-0.17416667 44.48111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971743",
		"itemLabel": "château du Monteil",
		"geo": "Point(1.93861 45.9293)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971747",
		"itemLabel": "château du Moutier",
		"geo": "Point(3.34694 46.4729)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971748",
		"itemLabel": "château du Muguet",
		"geo": "Point(2.874 47.6801)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971750",
		"itemLabel": "château du Méage",
		"geo": "Point(3.46492 46.2884)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971751",
		"itemLabel": "château du Méjanel",
		"geo": "Point(2.97033 44.3192)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971753",
		"itemLabel": "château du Neubourg",
		"geo": "Point(0.899634 49.1484)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971754",
		"itemLabel": "château du Parangon",
		"geo": "Point(2.47083 48.8139)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971756",
		"itemLabel": "château du Parc",
		"geo": "Point(1.68095 46.8121)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971758",
		"itemLabel": "château du Passage",
		"geo": "Point(5.51334 45.529)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971759",
		"itemLabel": "château du Paty",
		"geo": "Point(0.33528 47.6111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971760",
		"itemLabel": "château du Percher",
		"geo": "Point(-0.704488 47.7117)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971761",
		"itemLabel": "château du Petit-Perray",
		"geo": "Point(0.32139 47.6558)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971762",
		"itemLabel": "château du Petit-Serrant",
		"geo": "Point(-0.617839 47.4103)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971763",
		"itemLabel": "château du Petit Montjeu",
		"geo": "Point(4.29986 46.9382)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971764",
		"itemLabel": "château du Peyruzel",
		"geo": "Point(1.19694 44.7599)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971765",
		"itemLabel": "château du Petit Trianon",
		"geo": "Point(2.10967 48.8156)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971766",
		"itemLabel": "château du Petit-Geroldseck",
		"geo": "Point(7.33222222 48.71444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971771",
		"itemLabel": "château du Petit-Ringelstein",
		"geo": "Point(7.31388889 48.57333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971776",
		"itemLabel": "château du Plantay",
		"geo": "Point(5.08131 46.0218)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971781",
		"itemLabel": "château du Plessis-Fortia",
		"geo": "Point(1.005277777 47.710833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971782",
		"itemLabel": "château du Plessis-Greffier",
		"geo": "Point(-0.287967 47.6544)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971784",
		"itemLabel": "château du Plessis-de-Vair",
		"geo": "Point(-1.0833 47.3949)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971789",
		"itemLabel": "château du Plessis",
		"geo": "Point(4.22524 48.222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971791",
		"itemLabel": "château du Plessis",
		"geo": "Point(-1.57489 47.118)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971793",
		"itemLabel": "château du Plessis",
		"geo": "Point(-1.48142 47.7243)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971794",
		"itemLabel": "château du Pont-de-Varenne",
		"geo": "Point(-0.275456 47.2286)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971796",
		"itemLabel": "château du Pradel",
		"geo": "Point(4.49948 44.581)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971798",
		"itemLabel": "château du Prieuré",
		"geo": "Point(2.09556 48.9925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971801",
		"itemLabel": "château du Puch de Gensac",
		"geo": "Point(-0.296333 44.7519)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971804",
		"itemLabel": "château du Périneau-Verrières",
		"geo": "Point(-0.461608 47.4629)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971805",
		"itemLabel": "château du Raguin",
		"geo": "Point(-0.895413 47.6227)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971807",
		"itemLabel": "château du Repaire",
		"geo": "Point(0.36556 45.5408)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971811",
		"itemLabel": "château du Riau",
		"geo": "Point(3.27733 46.6624)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971812",
		"itemLabel": "château du Ramstein",
		"geo": "Point(7.52277778 48.98472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971813",
		"itemLabel": "château du Roc",
		"geo": "Point(1.11804 44.9072)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971814",
		"itemLabel": "château du Rocher",
		"geo": "Point(-0.442222 48.1897)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971817",
		"itemLabel": "château du Roure",
		"geo": "Point(3.9467 44.4957)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971818",
		"itemLabel": "château du Rouvoltz",
		"geo": "Point(-0.273328 47.5389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971820",
		"itemLabel": "château du Rozay",
		"geo": "Point(4.75606 45.4765)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971822",
		"itemLabel": "château du Saix",
		"geo": "Point(6.31444 46.0669)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971823",
		"itemLabel": "château du Saulce",
		"geo": "Point(3.61927 47.723)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971824",
		"itemLabel": "château du Sauvement",
		"geo": "Point(4.3306 46.585)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971826",
		"itemLabel": "château du Solier",
		"geo": "Point(3.84061 44.2538)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971834",
		"itemLabel": "château du Théret",
		"geo": "Point(1.93715 46.1243)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971836",
		"itemLabel": "château du Tourps",
		"geo": "Point(-1.27028 49.6431)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971839",
		"itemLabel": "château du Tournel",
		"geo": "Point(3.70416667 44.49944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971843",
		"itemLabel": "château du Vieux-Bost",
		"geo": "Point(3.23786 46.4655)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971844",
		"itemLabel": "château du Vert-Bois",
		"geo": "Point(3.11485 50.7119)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971844",
		"itemLabel": "château du Vert-Bois",
		"geo": "Point(3.1149 50.7119)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971845",
		"itemLabel": "château du Vieux-Melay",
		"geo": "Point(3.26956 46.5755)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971846",
		"itemLabel": "château du Vieux Bagneux",
		"geo": "Point(-0.08958 47.2421)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971848",
		"itemLabel": "château du Vieux Chambord",
		"geo": "Point(3.56694 46.359)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971853",
		"itemLabel": "château du Vouchot",
		"geo": "Point(4.14128 46.9656)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971854",
		"itemLabel": "château du Vousset",
		"geo": "Point(3.27272 46.3534)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971856",
		"itemLabel": "château d'Aubigny",
		"geo": "Point(6.27306 49.1017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971873",
		"itemLabel": "château les Bouysses",
		"geo": "Point(1.38333 44.4856)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971879",
		"itemLabel": "château royal de Senlis et prieuré Saint-Maurice",
		"geo": "Point(2.5842 49.2074)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971881",
		"itemLabel": "château vicomtal Saint-Pierre de Fenouillet",
		"geo": "Point(2.3806 42.793)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971914",
		"itemLabel": "châteaux de Château-Verdun et de Gudanes",
		"geo": "Point(1.68033 42.7838)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971917",
		"itemLabel": "châteaux de Bruniquel",
		"geo": "Point(1.666111111 44.056111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970049",
		"itemLabel": "château de Montréal",
		"geo": "Point(4.29289 44.5292)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970054",
		"itemLabel": "château de Montseveny",
		"geo": "Point(4.312 44.635)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970060",
		"itemLabel": "château de Montréal",
		"geo": "Point(0.430833333 45.011666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970061",
		"itemLabel": "château de Montvéran",
		"geo": "Point(5.7772 45.8499)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970062",
		"itemLabel": "château de Morains",
		"geo": "Point(-0.0228 47.2382)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970064",
		"itemLabel": "château de Morlet",
		"geo": "Point(4.50891 46.9537)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970065",
		"itemLabel": "château de Mornay",
		"geo": "Point(-0.436389 46.0236)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970071",
		"itemLabel": "château de Mortillon",
		"geo": "Point(3.89083 46.4764)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970072",
		"itemLabel": "château de Mostuéjouls",
		"geo": "Point(3.18361 44.2036)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970073",
		"itemLabel": "château de Mouans",
		"geo": "Point(6.9692 43.6206)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970074",
		"itemLabel": "château de Moucheton",
		"geo": "Point(3.43332 49.1182)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970077",
		"itemLabel": "château de Moulin-Neuf",
		"geo": "Point(4.4535 44.0324)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970078",
		"itemLabel": "château de Moulins-Engilbert",
		"geo": "Point(3.81032 46.9885)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970081",
		"itemLabel": "château de Moyen",
		"geo": "Point(6.5706 48.4821)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970083",
		"itemLabel": "château de Mousson",
		"geo": "Point(6.0775 48.90472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970085",
		"itemLabel": "château de Murat",
		"geo": "Point(2.90683 46.4)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970087",
		"itemLabel": "château de Mâchuraz",
		"geo": "Point(5.7035 45.8764)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970088",
		"itemLabel": "château de Médan",
		"geo": "Point(1.99428 48.9527)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970089",
		"itemLabel": "château de Médavy",
		"geo": "Point(0.09778 48.6786)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970091",
		"itemLabel": "château de Ménessaire",
		"geo": "Point(4.1447 47.1319)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970092",
		"itemLabel": "château de Mélac",
		"geo": "Point(2.96337 44.0134)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970093",
		"itemLabel": "château de Mursay",
		"geo": "Point(-0.470277777 46.376944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970095",
		"itemLabel": "château de Méry-sur-Oise",
		"geo": "Point(2.18972 49.0661)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970097",
		"itemLabel": "château de Mézens",
		"geo": "Point(1.6717 43.7875)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970098",
		"itemLabel": "château de Mézerville",
		"geo": "Point(1.79295 43.26)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970100",
		"itemLabel": "château de Nacqueville",
		"geo": "Point(-1.72306 49.6622)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970106",
		"itemLabel": "château de Narcé",
		"geo": "Point(-0.428832 47.4434)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970109",
		"itemLabel": "château de Nangis",
		"geo": "Point(3.01361111 48.55444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970110",
		"itemLabel": "château de Naves",
		"geo": "Point(3.11039 46.175)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970113",
		"itemLabel": "château de Nassigny",
		"geo": "Point(2.60588 46.4981)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970115",
		"itemLabel": "château de Nesles",
		"geo": "Point(3.56913 49.2039)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970116",
		"itemLabel": "château de Ners",
		"geo": "Point(5.52638889 43.36805556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970121",
		"itemLabel": "château de Nemours",
		"geo": "Point(2.69694444 48.26555556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970124",
		"itemLabel": "château de Neuville",
		"geo": "Point(1.66944 48.7675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970125",
		"itemLabel": "château de Neuville",
		"geo": "Point(2.82833 46.4202)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970130",
		"itemLabel": "château de Nieul-lès-Saintes",
		"geo": "Point(-0.748889 45.7558)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970134",
		"itemLabel": "château de Nitray",
		"geo": "Point(0.894501 47.3409)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970136",
		"itemLabel": "château de Noailly",
		"geo": "Point(3.48631 46.2188)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970142",
		"itemLabel": "château de Nointel",
		"geo": "Point(2.01444 49.1958)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970147",
		"itemLabel": "château de Novel",
		"geo": "Point(6.135 45.9183)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970148",
		"itemLabel": "château de Noyant-d'Allier",
		"geo": "Point(3.12656 46.4795)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970150",
		"itemLabel": "château de Noyers-sur-Serein",
		"geo": "Point(3.9975 47.7011)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970151",
		"itemLabel": "château de Nozeroy",
		"geo": "Point(6.0356 46.7731)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970155",
		"itemLabel": "château de Nuits",
		"geo": "Point(4.21478 47.7331)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970156",
		"itemLabel": "château de Noirmoutier",
		"geo": "Point(-2.2425 47.000277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970157",
		"itemLabel": "château de Néhou",
		"geo": "Point(-1.52904 49.4201)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970160",
		"itemLabel": "château de Paars",
		"geo": "Point(3.59778 49.3281)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970162",
		"itemLabel": "château de Pagax",
		"geo": "Point(2.25194 44.6083)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970164",
		"itemLabel": "château de Pailhès",
		"geo": "Point(1.44492 43.1006)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970165",
		"itemLabel": "château de Padern",
		"geo": "Point(2.6556 42.8675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970166",
		"itemLabel": "château de Paley",
		"geo": "Point(2.86265 48.241)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970168",
		"itemLabel": "château de Panat",
		"geo": "Point(2.42472 44.4303)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970169",
		"itemLabel": "château de Pampelonne",
		"geo": "Point(4.66392 44.6324)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970172",
		"itemLabel": "château de Panessière",
		"geo": "Point(3.45503 46.6349)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970175",
		"itemLabel": "château de Panloy",
		"geo": "Point(-0.686667 45.8425)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970176",
		"itemLabel": "château de Panloup",
		"geo": "Point(3.35447 46.5538)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970178",
		"itemLabel": "château de Paray",
		"geo": "Point(3.61258 46.6523)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970179",
		"itemLabel": "château de Parentignat",
		"geo": "Point(3.29163 45.5328)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970182",
		"itemLabel": "château de Parthenay",
		"geo": "Point(-0.251944 46.6522)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970183",
		"itemLabel": "château de Parpeville",
		"geo": "Point(3.54853 49.7855)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970184",
		"itemLabel": "château de Parpacé",
		"geo": "Point(-0.103605 47.5031)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970186",
		"itemLabel": "château de Passay",
		"geo": "Point(0.368056 48.1017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970187",
		"itemLabel": "château de Passavant",
		"geo": "Point(-0.390659 47.1045)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970188",
		"itemLabel": "château de Passy-Véron",
		"geo": "Point(3.30573 48.1136)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970191",
		"itemLabel": "château de Payra-sur-l'Hers",
		"geo": "Point(1.85426 43.2665)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970192",
		"itemLabel": "château de Pennautier",
		"geo": "Point(2.31778 43.2436)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970193",
		"itemLabel": "château de Penne",
		"geo": "Point(1.72728 44.0783)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970194",
		"itemLabel": "château de Pennesuyt",
		"geo": "Point(5.2544 46.20193)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970197",
		"itemLabel": "château de Pernant",
		"geo": "Point(3.22733 49.3749)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970200",
		"itemLabel": "château de Pesselières",
		"geo": "Point(2.7783 47.2161)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970206",
		"itemLabel": "château de Peyras",
		"geo": "Point(0.60639 45.8717)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970211",
		"itemLabel": "château de Peyrelade",
		"geo": "Point(3.147777777 44.195277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970216",
		"itemLabel": "château de Pierre-Levée",
		"geo": "Point(-1.75015 46.5283)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970218",
		"itemLabel": "château de Pierre-Perthuis",
		"geo": "Point(3.78416 47.433)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970219",
		"itemLabel": "château de Pierre-de-Bresse",
		"geo": "Point(5.26556 46.8819)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970222",
		"itemLabel": "château de Pierreclos",
		"geo": "Point(4.68611 46.33)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970224",
		"itemLabel": "château de Piffonds",
		"geo": "Point(3.14635 48.0548)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970226",
		"itemLabel": "château de Pignerolle",
		"geo": "Point(-0.473802 47.4699)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970227",
		"itemLabel": "château de Pierrefort",
		"geo": "Point(5.93861111 48.84138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970229",
		"itemLabel": "château de Pimpéan",
		"geo": "Point(-0.341914 47.3218)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970230",
		"itemLabel": "château de Pieusse",
		"geo": "Point(2.232361111 43.080555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970233",
		"itemLabel": "château de Pisy",
		"geo": "Point(4.13749 47.5539)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970236",
		"itemLabel": "château de Plain-Marais",
		"geo": "Point(-1.37222 49.3531)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970239",
		"itemLabel": "château de Plassac",
		"geo": "Point(-0.5637 45.4708)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970240",
		"itemLabel": "château de Planèzes",
		"geo": "Point(2.53773 44.2955)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970242",
		"itemLabel": "château de Plieux",
		"geo": "Point(0.732291 43.9506)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970243",
		"itemLabel": "château de Pocé",
		"geo": "Point(-0.122378 47.2354)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970249",
		"itemLabel": "château de Pomas",
		"geo": "Point(2.29139 43.1111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970250",
		"itemLabel": "château de Pomay",
		"geo": "Point(3.44636 46.5744)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970256",
		"itemLabel": "château de Pommiers de Saint-Félix-de-Foncaude",
		"geo": "Point(-0.100626 44.6557)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970259",
		"itemLabel": "château de Pommier",
		"geo": "Point(0.72666667 45.46194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970260",
		"itemLabel": "château de Poncin",
		"geo": "Point(5.4105 46.0869)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970261",
		"itemLabel": "château de Pommiers",
		"geo": "Point(-0.32166667 44.98777778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970262",
		"itemLabel": "château de Poncé",
		"geo": "Point(0.658889 47.7625)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970264",
		"itemLabel": "château de Pont-Chevron",
		"geo": "Point(2.7699 47.6898)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970266",
		"itemLabel": "château de Ponneau",
		"geo": "Point(4.73362 46.6827)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970267",
		"itemLabel": "château de Pont-Saint-Mard",
		"geo": "Point(3.28413 49.4997)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970268",
		"itemLabel": "château de Pont-d'Ain",
		"geo": "Point(5.34472 46.0525)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970269",
		"itemLabel": "château de Pont-de-Briques",
		"geo": "Point(1.62694 50.6856)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970270",
		"itemLabel": "château de Pont-de-Veyle",
		"geo": "Point(4.88476 46.2658)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2421853",
		"itemLabel": "château de Mauriac",
		"geo": "Point(0.43222222 45.08888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2422758",
		"itemLabel": "château de Chavaniac",
		"geo": "Point(3.579166666 45.157222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2427552",
		"itemLabel": "château de Comper",
		"geo": "Point(-2.172877777 48.070136111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2429145",
		"itemLabel": "château de Rochecotte",
		"geo": "Point(0.306944444 47.287222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2434153",
		"itemLabel": "château du Val",
		"geo": "Point(2.10641 48.921)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2436626",
		"itemLabel": "château de Lavagnac",
		"geo": "Point(3.48389 43.4819)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2441338",
		"itemLabel": "château de Belhade",
		"geo": "Point(-0.70055556 44.37722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2456478",
		"itemLabel": "château du Mesnil-Geoffroy",
		"geo": "Point(0.783473 49.8123)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2457103",
		"itemLabel": "château de Trigonant",
		"geo": "Point(0.81666667 45.20805556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2458579",
		"itemLabel": "château de Vouzan",
		"geo": "Point(0.345 45.5986)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2461512",
		"itemLabel": "château de Chasselas",
		"geo": "Point(4.72172 46.2748)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2470077",
		"itemLabel": "château des évêques de Montpellier",
		"geo": "Point(3.80611 43.5864)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2473730",
		"itemLabel": "château de Bercy",
		"geo": "Point(2.40112 48.8275)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2480350",
		"itemLabel": "château de Barbezieux",
		"geo": "Point(-0.1575 45.473055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2482855",
		"itemLabel": "château des ducs de Bourbon à Montluçon",
		"geo": "Point(2.60355 46.3401)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2483849",
		"itemLabel": "château d'Assier",
		"geo": "Point(1.8786 44.675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2488089",
		"itemLabel": "château de Beynes",
		"geo": "Point(1.874444444 48.856388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2499665",
		"itemLabel": "château de Beaumont",
		"geo": "Point(3.1275 46.6214)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2501434",
		"itemLabel": "château d'Eu",
		"geo": "Point(1.416944444 50.049444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2507005",
		"itemLabel": "château de Villemolin",
		"geo": "Point(3.71972222 47.28722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2511495",
		"itemLabel": "château de Cazilhac",
		"geo": "Point(3.1672 43.6936)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2511903",
		"itemLabel": "château de Brécy",
		"geo": "Point(-0.57417 49.2636)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2517770",
		"itemLabel": "château de Meux",
		"geo": "Point(-0.3484 45.444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2517770",
		"itemLabel": "château de Meux",
		"geo": "Point(-0.34833 45.4442)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2519490",
		"itemLabel": "château de Créminil",
		"geo": "Point(2.32844 50.592)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2520602",
		"itemLabel": "château de Flers",
		"geo": "Point(-0.57566111 48.75091111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2533511",
		"itemLabel": "château de Saint-Laurent-le-Minier",
		"geo": "Point(3.655 43.933)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2533803",
		"itemLabel": "château de Poussan-le-Haut",
		"geo": "Point(3.21899 43.3476)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2540016",
		"itemLabel": "château de Bourgon",
		"geo": "Point(-0.561 48.223)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2553023",
		"itemLabel": "château de la Seilleraye",
		"geo": "Point(-1.4206 47.2995)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2555498",
		"itemLabel": "château de Couffour",
		"geo": "Point(3.001944444 44.844166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2567187",
		"itemLabel": "château de Fozières",
		"geo": "Point(3.35778 43.7525)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2578045",
		"itemLabel": "château de Baneuil",
		"geo": "Point(0.69 44.8525)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2583763",
		"itemLabel": "château du Vieux Mujolan",
		"geo": "Point(3.7655 43.5377)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2587094",
		"itemLabel": "château de Ventadour",
		"geo": "Point(2.116666666 45.392222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2593302",
		"itemLabel": "château du Repas",
		"geo": "Point(-0.3572 48.7682)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2599121",
		"itemLabel": "château de Villersexel",
		"geo": "Point(6.43 47.5522)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2608510",
		"itemLabel": "château de l'Oisellerie",
		"geo": "Point(0.10416667 45.625)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2612600",
		"itemLabel": "château des ducs de Bar",
		"geo": "Point(5.1562 48.7717)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2615917",
		"itemLabel": "château de Bellevue",
		"geo": "Point(2.227777777 48.821944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2625757",
		"itemLabel": "château d'Autreville-sur-la-Renne",
		"geo": "Point(4.9761 48.1154)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2625767",
		"itemLabel": "château des Bories",
		"geo": "Point(0.84388889 45.21888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2628194",
		"itemLabel": "château d'Olhain",
		"geo": "Point(2.583333333 50.424166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2630287",
		"itemLabel": "château d'Arboras",
		"geo": "Point(3.48556 43.7117)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2633625",
		"itemLabel": "château de Brest",
		"geo": "Point(-4.494708333 48.381255555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2633925",
		"itemLabel": "château d'Aulnois",
		"geo": "Point(6.3133 48.8693)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2636044",
		"itemLabel": "château de Montmelas",
		"geo": "Point(4.62167 46.0111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2640864",
		"itemLabel": "château de l'Anglais",
		"geo": "Point(7.29421 43.6895)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2644482",
		"itemLabel": "château de Jonquières",
		"geo": "Point(3.47639 43.6761)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2647176",
		"itemLabel": "château des Granges",
		"geo": "Point(3.27806 46.1294)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2650807",
		"itemLabel": "château de Miremont",
		"geo": "Point(2.2771 45.2678)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2661182",
		"itemLabel": "château de Cambous",
		"geo": "Point(3.72556 43.7542)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2665983",
		"itemLabel": "château du Mazeau",
		"geo": "Point(1.8965 45.6809)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2673929",
		"itemLabel": "château de Bocaud",
		"geo": "Point(3.91222 43.6614)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2675627",
		"itemLabel": "château médiéval de Pouancé",
		"geo": "Point(-1.175 47.74138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2677480",
		"itemLabel": "château royal du Vivier",
		"geo": "Point(2.84889 48.6861)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2679755",
		"itemLabel": "château d'Ingrandes",
		"geo": "Point(0.9625 46.5971)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2680235",
		"itemLabel": "château de Mortefontaine",
		"geo": "Point(2.60355 49.1101)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2680257",
		"itemLabel": "château du Taillis",
		"geo": "Point(0.8525 49.468)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2680279",
		"itemLabel": "château de Marracq",
		"geo": "Point(-1.48353 43.4799)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2686300",
		"itemLabel": "château de Chambes",
		"geo": "Point(0.5806 45.9094)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2689530",
		"itemLabel": "château de Cléron",
		"geo": "Point(6.0575 47.08777778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2693243",
		"itemLabel": "château de la Bretesche",
		"geo": "Point(-2.17193 47.4829)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2693777",
		"itemLabel": "château de Moidière",
		"geo": "Point(5.1252 45.5958)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2696077",
		"itemLabel": "château de Ribaute",
		"geo": "Point(3.23778 43.4194)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2700205",
		"itemLabel": "château de Menthon-Saint-Bernard",
		"geo": "Point(6.203611111 45.864166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2701702",
		"itemLabel": "château de Moncley",
		"geo": "Point(5.88809 47.3114)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2706740",
		"itemLabel": "château de Belcastel",
		"geo": "Point(2.336111111 44.388888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2707866",
		"itemLabel": "château de Chassy",
		"geo": "Point(3.77665 47.201)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2711461",
		"itemLabel": "château de Couterne",
		"geo": "Point(-0.4133 48.5352)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2715327",
		"itemLabel": "château de Castillon",
		"geo": "Point(-0.796388888 44.005833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2718236",
		"itemLabel": "château de Hayes",
		"geo": "Point(6.365 49.1664)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2721241",
		"itemLabel": "tour Solidor",
		"geo": "Point(-2.026111111 48.633888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2724447",
		"itemLabel": "château fort de Lourdes",
		"geo": "Point(-0.049166666 43.096666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2728816",
		"itemLabel": "château de Richelieu",
		"geo": "Point(0.326056 47.0075)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2729031",
		"itemLabel": "château de Taillebourg",
		"geo": "Point(-0.6475 45.833888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2729041",
		"itemLabel": "château de Pibrac",
		"geo": "Point(1.28694444 43.61916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2736061",
		"itemLabel": "château d'Orgeval",
		"geo": "Point(2.33822 48.6585)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2736607",
		"itemLabel": "château d'Agel",
		"geo": "Point(2.85389 43.3386)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2738641",
		"itemLabel": "château des Tourelles",
		"geo": "Point(1.488611111 49.098055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2740328",
		"itemLabel": "château de Montbrun",
		"geo": "Point(0.898055555 45.636111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2744194",
		"itemLabel": "château d'Aulteribe",
		"geo": "Point(3.49888889 45.775)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2744196",
		"itemLabel": "château de Jumilhac",
		"geo": "Point(1.06 45.49305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2744204",
		"itemLabel": "château de Ventadour",
		"geo": "Point(4.28694444 44.67)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2745671",
		"itemLabel": "château de Lumagne",
		"geo": "Point(4.79784 45.6865)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2745916",
		"itemLabel": "château de Lastours",
		"geo": "Point(1.12111111 45.64944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2746222",
		"itemLabel": "château de la Belle au bois dormant",
		"geo": "Point(-117.918971 33.812796)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2746222",
		"itemLabel": "château de la Belle au bois dormant",
		"geo": "Point(2.8043 48.8694)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2746222",
		"itemLabel": "château de la Belle au bois dormant",
		"geo": "Point(114.0692 22.3082)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2748605",
		"itemLabel": "château de Montfort",
		"geo": "Point(4.325 47.5925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2749538",
		"itemLabel": "château de Ranrouët",
		"geo": "Point(-2.298888888 47.444444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2749729",
		"itemLabel": "château de Blain",
		"geo": "Point(-1.76472222 47.46666667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2749738",
		"itemLabel": "château de Nobles",
		"geo": "Point(4.78583333 46.54138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2749741",
		"itemLabel": "château de Nérac",
		"geo": "Point(0.34 44.13527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2751516",
		"itemLabel": "château de Montjeu",
		"geo": "Point(4.2843 46.9026)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2763009",
		"itemLabel": "château de Saint-Germain",
		"geo": "Point(0.86333333 44.66055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2763769",
		"itemLabel": "château de Ray-sur-Saône",
		"geo": "Point(5.8283 47.5896)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2766341",
		"itemLabel": "château de Lantilly",
		"geo": "Point(3.71995 47.2364)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2779370",
		"itemLabel": "château de Jonzac",
		"geo": "Point(-0.431111 45.4456)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2781459",
		"itemLabel": "château de la Forêt",
		"geo": "Point(2.8204 47.8938)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970273",
		"itemLabel": "château de Pontchartrain",
		"geo": "Point(1.894929 48.798795)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970276",
		"itemLabel": "château de Pontécoulant",
		"geo": "Point(-0.58972 48.8964)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970279",
		"itemLabel": "château de Pordor",
		"geo": "Point(-2.00684 47.6633)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970280",
		"itemLabel": "château de Posanges",
		"geo": "Point(4.526111111 47.418333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970281",
		"itemLabel": "château de Potelle",
		"geo": "Point(3.67003 50.247)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970282",
		"itemLabel": "château de Pontivy",
		"geo": "Point(-2.9635 48.0704)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970285",
		"itemLabel": "château de Pornic",
		"geo": "Point(-2.105555555 47.113888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970288",
		"itemLabel": "château de Pouy-sur-Vannes",
		"geo": "Point(3.59091 48.3027)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970289",
		"itemLabel": "château de Pouthet",
		"geo": "Point(0.412944 44.6803)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970291",
		"itemLabel": "château de Pouzauges",
		"geo": "Point(-0.839722 46.7853)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970292",
		"itemLabel": "château de Pouzeux",
		"geo": "Point(3.34967 46.5585)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970293",
		"itemLabel": "château de Praisnaud",
		"geo": "Point(0.57306 45.9867)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970294",
		"itemLabel": "château de Pouzy",
		"geo": "Point(3.00517 46.71)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970295",
		"itemLabel": "château de Prades",
		"geo": "Point(3.45917 44.3506)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970297",
		"itemLabel": "château de Preisch",
		"geo": "Point(6.21584 49.4983)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970298",
		"itemLabel": "château de Pramenoux",
		"geo": "Point(4.4736 46.0591)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970299",
		"itemLabel": "château de Presles",
		"geo": "Point(3.62592 49.5017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970302",
		"itemLabel": "château de Promery",
		"geo": "Point(6.11349 45.9546)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970303",
		"itemLabel": "château de Prunoy",
		"geo": "Point(3.12452 47.9086)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970305",
		"itemLabel": "château de Puisieux-et-Clanlieu",
		"geo": "Point(3.67653 49.8561)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970308",
		"itemLabel": "château de Pupetières",
		"geo": "Point(5.45467 45.4594)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970309",
		"itemLabel": "château de Puy-Guillon",
		"geo": "Point(2.96717 46.2635)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970311",
		"itemLabel": "château de Puy-Vozelle",
		"geo": "Point(3.33886 46.1159)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970312",
		"itemLabel": "château de Puybautier",
		"geo": "Point(0.41917 46.0094)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970313",
		"itemLabel": "château de Puyfol",
		"geo": "Point(3.55972 46.3069)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970315",
		"itemLabel": "château de Puybardeau",
		"geo": "Point(2.155 46.49222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970316",
		"itemLabel": "château de Puyferrat",
		"geo": "Point(0.50666667 45.14888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970318",
		"itemLabel": "château de Puyvidal",
		"geo": "Point(0.34111 45.7236)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970320",
		"itemLabel": "château de Pépinvast",
		"geo": "Point(-1.33521 49.6263)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970324",
		"itemLabel": "château de Puyguilhem",
		"geo": "Point(0.74683333 45.42019444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970324",
		"itemLabel": "château de Puyguilhem",
		"geo": "Point(0.74444444 45.42583333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970325",
		"itemLabel": "château de Pymont",
		"geo": "Point(5.5442 46.6886)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970326",
		"itemLabel": "château de Quevauvillers",
		"geo": "Point(2.08 49.8257)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970327",
		"itemLabel": "château de Quincy",
		"geo": "Point(2.1575 47.1331)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970328",
		"itemLabel": "château de Quillan",
		"geo": "Point(2.18675 42.8747)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970329",
		"itemLabel": "château de Quincy-sous-le-Mont",
		"geo": "Point(3.55313 49.3066)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970330",
		"itemLabel": "château de Quirieu",
		"geo": "Point(5.43972 45.7881)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970331",
		"itemLabel": "château de Quéhillac",
		"geo": "Point(-1.90325 47.4331)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970334",
		"itemLabel": "château de Quérigut",
		"geo": "Point(2.09778 42.6994)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970335",
		"itemLabel": "château de Ragny",
		"geo": "Point(4.06926 47.4946)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970339",
		"itemLabel": "château de Ransanne",
		"geo": "Point(-0.800556 45.7797)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970341",
		"itemLabel": "château de Rapetour",
		"geo": "Point(4.60861 45.938)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970346",
		"itemLabel": "château de Rauzan",
		"geo": "Point(-0.12666667 44.78055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970349",
		"itemLabel": "château de Ravignan",
		"geo": "Point(-0.283333 43.875556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970351",
		"itemLabel": "château de Recours",
		"geo": "Point(3.94189 45.1402)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970354",
		"itemLabel": "château de Remilly-Aillicourt",
		"geo": "Point(4.99444 49.6518)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970355",
		"itemLabel": "château de Remilly-les-Pothées",
		"geo": "Point(4.53342 49.7815)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970357",
		"itemLabel": "château de Ressouches",
		"geo": "Point(3.31694 44.4794)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970358",
		"itemLabel": "château de Retail",
		"geo": "Point(-1.56763 46.8715)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970361",
		"itemLabel": "château de Respide",
		"geo": "Point(-0.225055555 44.532944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970362",
		"itemLabel": "château de Reynel",
		"geo": "Point(5.3375 48.292)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970363",
		"itemLabel": "château de Reverseaux",
		"geo": "Point(1.56556 48.2672)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970364",
		"itemLabel": "château de Reuilly"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970367",
		"itemLabel": "château de Ricey-Bas",
		"geo": "Point(4.37028 48.005)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970369",
		"itemLabel": "château de Reynerie",
		"geo": "Point(1.39747 43.5729)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970370",
		"itemLabel": "château de Richemont",
		"geo": "Point(5.27162 46.0093)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970371",
		"itemLabel": "château de Rieux-Minervois",
		"geo": "Point(2.5857 43.284)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970372",
		"itemLabel": "château de Rilhat",
		"geo": "Point(3.33678 46.1061)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970373",
		"itemLabel": "château de Richemont",
		"geo": "Point(0.61388889 45.41055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970374",
		"itemLabel": "château de Rioux",
		"geo": "Point(-0.708056 45.6494)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970376",
		"itemLabel": "château de Ris",
		"geo": "Point(3.25492 46.4715)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970380",
		"itemLabel": "château de Roberval",
		"geo": "Point(2.68855 49.2904)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970381",
		"itemLabel": "château de Rocan",
		"geo": "Point(4.86704 49.6359)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970382",
		"itemLabel": "château de Rives",
		"geo": "Point(6.47803 46.378)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970383",
		"itemLabel": "château de Rochambeau",
		"geo": "Point(0.9819 47.7964)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970384",
		"itemLabel": "château de Roche-sur-Loue",
		"geo": "Point(5.7963 47.0423)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970385",
		"itemLabel": "château de Robert le Diable",
		"geo": "Point(0.95972222 49.33958333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970386",
		"itemLabel": "château de Rochebaron",
		"geo": "Point(4.1 45.3157)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970389",
		"itemLabel": "château de Rochebrune",
		"geo": "Point(0.78722 45.8967)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970391",
		"itemLabel": "château de Rochechinard",
		"geo": "Point(5.24 45.0306)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970396",
		"itemLabel": "château de Rochebonne",
		"geo": "Point(4.61722 45.9408)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970397",
		"itemLabel": "château de Rochefort-en-Valdaine",
		"geo": "Point(4.85417 44.5111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970398",
		"itemLabel": "château de Rochefort-en-Yvelines",
		"geo": "Point(1.99056 48.5867)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970400",
		"itemLabel": "château de Rochefort-sur-Charente"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970401",
		"itemLabel": "château de Rochefort-sur-Séran",
		"geo": "Point(5.76744 45.7881)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970403",
		"itemLabel": "château de Rochefort",
		"geo": "Point(3.2545 46.4696)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970404",
		"itemLabel": "château de Rochemaure",
		"geo": "Point(4.70017 44.5873)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970406",
		"itemLabel": "château de Rochechouart",
		"geo": "Point(0.819166666 45.821388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970408",
		"itemLabel": "château de Rochetaillée-sur-Saône",
		"geo": "Point(4.83611 45.8425)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970409",
		"itemLabel": "château de Rochemorin",
		"geo": "Point(-0.5625 44.72138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970410",
		"itemLabel": "château de Rognac",
		"geo": "Point(3.63873 49.2017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970411",
		"itemLabel": "château de Roissac",
		"geo": "Point(-0.28306 45.6175)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970414",
		"itemLabel": "château de Romefort",
		"geo": "Point(-0.681944 45.7769)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970415",
		"itemLabel": "château de Romefort",
		"geo": "Point(1.2375 46.6222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970418",
		"itemLabel": "château de Roquecourbe-Minervois",
		"geo": "Point(2.6486 43.2206)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970419",
		"itemLabel": "château de Roquedols",
		"geo": "Point(3.4389 44.1619)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970422",
		"itemLabel": "château de Roquefère",
		"geo": "Point(2.37806 43.3733)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970423",
		"itemLabel": "château de Roquelaure",
		"geo": "Point(2.82268 44.4929)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970431",
		"itemLabel": "château de Rosey",
		"geo": "Point(4.7083 46.7439)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970432",
		"itemLabel": "château de Rosières-près-Troyes",
		"geo": "Point(4.07903 48.2607)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970440",
		"itemLabel": "château de Rougemont (Ain)",
		"geo": "Point(5.52556 46.0058)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970446",
		"itemLabel": "château de Roussillon",
		"geo": "Point(4.81147 45.3734)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970447",
		"itemLabel": "château de Roussillon",
		"geo": "Point(1.458 44.5178)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970449",
		"itemLabel": "château de Rouville",
		"geo": "Point(2.41167 48.3044)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970450",
		"itemLabel": "château de Rouvres"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970452",
		"itemLabel": "château de Ruat",
		"geo": "Point(-1.02764 44.6388)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970454",
		"itemLabel": "château de Ruffey",
		"geo": "Point(4.85111 46.6292)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970456",
		"itemLabel": "château de Rumilly",
		"geo": "Point(5.94222 45.8678)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970459",
		"itemLabel": "château de Ruynes",
		"geo": "Point(3.2254 44.9992)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970460",
		"itemLabel": "château de Rully",
		"geo": "Point(4.735277777 46.869166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970468",
		"itemLabel": "château de Réghat",
		"geo": "Point(2.43557 48.8004)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970470",
		"itemLabel": "château de Réquista",
		"geo": "Point(2.13303 44.3455)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970472",
		"itemLabel": "château de Réveillon",
		"geo": "Point(3.45611 48.7528)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970473",
		"itemLabel": "château de Sablé",
		"geo": "Point(-0.332778 47.8381)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970475",
		"itemLabel": "château de Saint-Agil",
		"geo": "Point(0.92639 48.0333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970477",
		"itemLabel": "château de Saint-Aignan",
		"geo": "Point(0.34167 48.2119)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970479",
		"itemLabel": "château de Saint-Alban",
		"geo": "Point(3.38917 44.7817)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970484",
		"itemLabel": "château de Saint-André",
		"geo": "Point(5.47902 45.7741)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970486",
		"itemLabel": "château de Saint-André du Coing",
		"geo": "Point(4.7854 45.8186)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970488",
		"itemLabel": "château de Saint-Aubin-sur-Loire",
		"geo": "Point(3.74977 46.5746)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970493",
		"itemLabel": "château de Saint-Aventin",
		"geo": "Point(4.16331 48.2201)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970494",
		"itemLabel": "château de Saint-Beauzély",
		"geo": "Point(2.95792 44.1642)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970495",
		"itemLabel": "château de Saint-Benoist-sur-Vanne",
		"geo": "Point(3.67208 48.232)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970496",
		"itemLabel": "château de Saint-Bernard",
		"geo": "Point(4.73266 45.9445)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970498",
		"itemLabel": "château de Saint-Brice",
		"geo": "Point(-0.2778 45.6869)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970499",
		"itemLabel": "château de Saint-Chamant",
		"geo": "Point(2.44588 45.0883)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970501",
		"itemLabel": "château de Saint-Cyr",
		"geo": "Point(4.81778 45.8147)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970503",
		"itemLabel": "château de Saint-Denis-en-Bugey",
		"geo": "Point(5.33387 45.9493)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970504",
		"itemLabel": "château de Saint-Chartier",
		"geo": "Point(1.97661 46.6471)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970505",
		"itemLabel": "château de Saint-Denis-sur-Loire",
		"geo": "Point(1.38868 47.624)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970506",
		"itemLabel": "château de Saint-Geniez de Bertrand",
		"geo": "Point(3.02256 44.0425)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970508",
		"itemLabel": "château de Saint-Crépin (Saint-Crépin-de-Richemont)",
		"geo": "Point(0.59972222 45.41888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970509",
		"itemLabel": "château de Saint-Geniès",
		"geo": "Point(1.4849 43.683)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970510",
		"itemLabel": "château de Saint-Ferriol",
		"geo": "Point(2.22473 42.89177)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970512",
		"itemLabel": "château de Saint-Georges-Motel",
		"geo": "Point(1.36715 48.7884)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970513",
		"itemLabel": "château de Saint-Germain-de-Confolens",
		"geo": "Point(0.68528 46.0531)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970514",
		"itemLabel": "château de Saint-Germain (Ain)",
		"geo": "Point(5.37674 45.9487)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970516",
		"itemLabel": "château de Saint-Géran",
		"geo": "Point(3.40297 46.3731)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970519",
		"itemLabel": "château de Saint-Germain-du-Salembre",
		"geo": "Point(0.45083333 45.13916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970521",
		"itemLabel": "château de Saint-Germain-Beaupré",
		"geo": "Point(1.54555556 46.3125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970527",
		"itemLabel": "château de Saint-Jean-d'Angle",
		"geo": "Point(-0.95083 45.8206)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970531",
		"itemLabel": "château de Saint-Julien",
		"geo": "Point(5.29056 45.7328)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970533",
		"itemLabel": "château de Saint-Izaire",
		"geo": "Point(2.719444444 43.975277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970534",
		"itemLabel": "château de Saint-Julien d'Empare",
		"geo": "Point(2.07901 44.556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970535",
		"itemLabel": "château de Saint-Lambert",
		"geo": "Point(3.28907 44.5477)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970536",
		"itemLabel": "château de Saint-Loup-sur-Thouet",
		"geo": "Point(-0.168 46.7894)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970537",
		"itemLabel": "château de Saint-Just",
		"geo": "Point(1.43138889 49.11083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970539",
		"itemLabel": "château de Saint-Léger",
		"geo": "Point(6.20153 44.6447)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970542",
		"itemLabel": "château de Saint-Maime",
		"geo": "Point(5.79275 43.905)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970545",
		"itemLabel": "château de Saint-Marceau",
		"geo": "Point(4.72 49.7097)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970546",
		"itemLabel": "château de Saint-Mars-de-Coutais",
		"geo": "Point(-1.73839 47.1146)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970548",
		"itemLabel": "château de Saint-Malo",
		"geo": "Point(-2.0228 48.6514)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970549",
		"itemLabel": "château de Saint-Mars-la-Jaille",
		"geo": "Point(-1.19125 47.5233)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970550",
		"itemLabel": "château de Saint-Martin-de-Seignanx",
		"geo": "Point(-1.38909 43.5476)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970554",
		"itemLabel": "château de Saint-Maurice-Thizouaille",
		"geo": "Point(3.3639 47.833)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970557",
		"itemLabel": "château de Saint-Martin de Toques",
		"geo": "Point(2.8691 43.1289)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970560",
		"itemLabel": "château de Saint-Mesmin",
		"geo": "Point(-0.71778 46.7997)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970562",
		"itemLabel": "château de Saint-Maurice-sur-Adour",
		"geo": "Point(-0.46333333 43.78222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970568",
		"itemLabel": "château de Saint-Ouen de Chemazé",
		"geo": "Point(-0.77083 47.7914)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970569",
		"itemLabel": "château de Saint-Parres-aux-Tertres",
		"geo": "Point(4.11349 48.3063)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970571",
		"itemLabel": "château de Saint-Point",
		"geo": "Point(4.61528 46.3436)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970572",
		"itemLabel": "château de Saint-Pompont",
		"geo": "Point(1.14536 44.7266)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970573",
		"itemLabel": "château de Saint-Pont",
		"geo": "Point(3.29431 46.1644)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970575",
		"itemLabel": "château de Saint-Priest",
		"geo": "Point(1.86363 45.2999)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970576",
		"itemLabel": "château de Saint-Priest",
		"geo": "Point(4.944 45.6967)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970580",
		"itemLabel": "château de Saint-Saturnin",
		"geo": "Point(3.18861 44.4122)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970583",
		"itemLabel": "château de Saint-Thomé",
		"geo": "Point(4.62342 44.5012)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970584",
		"itemLabel": "château de Saint-Sénoch",
		"geo": "Point(0.919086 47.0631)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970586",
		"itemLabel": "château de Saint-Trys",
		"geo": "Point(4.70333 45.9533)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970587",
		"itemLabel": "château de Saint-Saturnin",
		"geo": "Point(3.09261 45.6587)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970588",
		"itemLabel": "château de Saint-Sauveur-le-Vicomte",
		"geo": "Point(-1.52805556 49.38638889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970591",
		"itemLabel": "château de Sainte-Eulalie-d'Olt",
		"geo": "Point(2.946161111 44.464086111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970593",
		"itemLabel": "château de Saint-Élix-le-Château",
		"geo": "Point(1.13638889 43.27805556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970596",
		"itemLabel": "château de Sainte-Hermine",
		"geo": "Point(-1.05694 46.5583)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970597",
		"itemLabel": "château de Sainte-Hélène-sur-Isère",
		"geo": "Point(6.31672 45.611)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970598",
		"itemLabel": "château de Sainte-Julie",
		"geo": "Point(5.2801 45.865)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970602",
		"itemLabel": "château de Sainte-Suzanne",
		"geo": "Point(-0.348494 48.0971)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970603",
		"itemLabel": "château de Sainte-Mère",
		"geo": "Point(0.666944444 44.005555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970605",
		"itemLabel": "château de Saix",
		"geo": "Point(5.22381 46.1644)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970606",
		"itemLabel": "château de Salbrune",
		"geo": "Point(2.89517 46.2573)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970608",
		"itemLabel": "château de Saligny",
		"geo": "Point(3.75422 46.4704)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970609",
		"itemLabel": "château de Salles",
		"geo": "Point(3.20911 46.1768)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970610",
		"itemLabel": "château de Salles-Curan",
		"geo": "Point(2.78807 44.1827)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970611",
		"itemLabel": "château de Sallèles",
		"geo": "Point(2.9475 43.2559)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970614",
		"itemLabel": "château de Salvagnac-Cajarc",
		"geo": "Point(1.84711 44.4753)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970616",
		"itemLabel": "château de Salm",
		"geo": "Point(7.14 48.45305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970617",
		"itemLabel": "château de Sampigny",
		"geo": "Point(3.1412 45.8247)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970620",
		"itemLabel": "château de Sancé",
		"geo": "Point(-0.100486 47.5858)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970628",
		"itemLabel": "château de Sanvensa",
		"geo": "Point(2.0454 44.2926)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970629",
		"itemLabel": "château de Saponay",
		"geo": "Point(3.47961 49.214)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970630",
		"itemLabel": "château de Sardan",
		"geo": "Point(4.0418 43.873)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970631",
		"itemLabel": "château de Sanzay",
		"geo": "Point(-0.440833333 46.960277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970636",
		"itemLabel": "château de Sassetot",
		"geo": "Point(0.529 49.8062)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970641",
		"itemLabel": "château de Saudreville",
		"geo": "Point(2.13048 48.4989)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970643",
		"itemLabel": "château de Sault",
		"geo": "Point(-0.672698 43.5489)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970644",
		"itemLabel": "château de Saulxures",
		"geo": "Point(6.7678 47.9475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970646",
		"itemLabel": "château de Sauvagnac",
		"geo": "Point(-0.198403 44.7704)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970649",
		"itemLabel": "château de Sauvigny-le-Bois",
		"geo": "Point(3.93938 47.5174)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970652",
		"itemLabel": "château de Sauvebœuf (Lalinde)",
		"geo": "Point(0.77611111 44.84833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970656",
		"itemLabel": "château de Sedaiges",
		"geo": "Point(2.48325 45.0017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970660",
		"itemLabel": "château de Segrez",
		"geo": "Point(2.17722 48.5461)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970662",
		"itemLabel": "château de Selles",
		"geo": "Point(3.2313 50.1817)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970663",
		"itemLabel": "château de Selves",
		"geo": "Point(2.33667 44.6442)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970664",
		"itemLabel": "château de Selore",
		"geo": "Point(4.0478 46.385)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970666",
		"itemLabel": "château de Segonzac",
		"geo": "Point(0.43361111 45.20444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970667",
		"itemLabel": "château de Semblançay",
		"geo": "Point(0.583 47.499)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970669",
		"itemLabel": "château de Semur-en-Brionnais",
		"geo": "Point(4.0881 46.2629)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970673",
		"itemLabel": "château de Sennecey-le-Grand",
		"geo": "Point(4.86917 46.6375)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970675",
		"itemLabel": "château de Senonnes",
		"geo": "Point(-1.2025 47.7986)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970676",
		"itemLabel": "château de Septmonts",
		"geo": "Point(3.36 49.335)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2795493",
		"itemLabel": "château de Dio",
		"geo": "Point(3.21112 43.6674)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2796619",
		"itemLabel": "Plessis-Josso",
		"geo": "Point(-2.594444444 47.629722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2803961",
		"itemLabel": "château de Longevergne",
		"geo": "Point(2.4583 45.2158)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2804460",
		"itemLabel": "château de Hac",
		"geo": "Point(-2.0059 48.3409)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2856283",
		"itemLabel": "château d'Alleuze",
		"geo": "Point(3.090833333 44.956111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2856295",
		"itemLabel": "château de l'Herbaudière",
		"geo": "Point(-0.231389 46.4253)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2883344",
		"itemLabel": "château Saint-Bauzille",
		"geo": "Point(3.21899 43.3476)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2883480",
		"itemLabel": "château de Jossigny",
		"geo": "Point(2.75361 48.8372)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2894861",
		"itemLabel": "Belleperche"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2900792",
		"itemLabel": "château de la Perrière",
		"geo": "Point(-0.587 47.5069)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2913406",
		"itemLabel": "château de Belvoir",
		"geo": "Point(6.6027 47.3174)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2941212",
		"itemLabel": "château d'Ételan",
		"geo": "Point(0.628055555 49.466388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2942728",
		"itemLabel": "château de la Flachère",
		"geo": "Point(4.55139 45.9122)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967787",
		"itemLabel": "château-Couvert",
		"geo": "Point(0.3728 46.6867)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967791",
		"itemLabel": "château-Gaillard",
		"geo": "Point(-2.75797 47.6569)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967793",
		"itemLabel": "château-Dauphin",
		"geo": "Point(2.854722 45.833889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967795",
		"itemLabel": "château-Guillaume",
		"geo": "Point(1.191738 46.480265)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967797",
		"itemLabel": "château-Naillac",
		"geo": "Point(1.06268 46.628914)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967799",
		"itemLabel": "château d'Allinges-Neuf",
		"geo": "Point(6.4639 46.3306)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967805",
		"itemLabel": "château d'Allinges-Vieux",
		"geo": "Point(6.46694 46.3325)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967807",
		"itemLabel": "château-bas de Sedan",
		"geo": "Point(4.94753 49.7023)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967809",
		"itemLabel": "château-ferme de Brieulles-sur-Bar",
		"geo": "Point(4.85366 49.4764)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967811",
		"itemLabel": "maison à Bar",
		"geo": "Point(4.83781 49.5739)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967820",
		"itemLabel": "château-prieuré de Pommiers-en-Forez",
		"geo": "Point(4.06423 45.829)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967830",
		"itemLabel": "château Barrière",
		"geo": "Point(0.71225 45.1814)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967835",
		"itemLabel": "château Beaugey",
		"geo": "Point(-0.48 44.80194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967839",
		"itemLabel": "château Bayard",
		"geo": "Point(6.018888888 45.423611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967840",
		"itemLabel": "château Bocé",
		"geo": "Point(-0.244226 47.6705)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967844",
		"itemLabel": "château Bontemps",
		"geo": "Point(5.7708 46.9031)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967845",
		"itemLabel": "château Boulard",
		"geo": "Point(-1.55899 43.475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967847",
		"itemLabel": "château Bouvet-Ladubay",
		"geo": "Point(-0.09997 47.2609)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967858",
		"itemLabel": "château Chavat",
		"geo": "Point(-0.357726 44.6559)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967862",
		"itemLabel": "château Corbeau",
		"geo": "Point(5.77778 45.2311)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967867",
		"itemLabel": "château Deganne",
		"geo": "Point(-1.1645 44.6631)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967869",
		"itemLabel": "château Dubuc",
		"geo": "Point(-60.8899 14.7682)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967871",
		"itemLabel": "château Dillon",
		"geo": "Point(-0.64222222 44.92083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967873",
		"itemLabel": "château Durtail",
		"geo": "Point(4.82722 44.9936)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967874",
		"itemLabel": "château Fadaise",
		"geo": "Point(4.35566 43.8359)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967882",
		"itemLabel": "château Ganne",
		"geo": "Point(-0.411365 48.9019)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967894",
		"itemLabel": "château Jacquard",
		"geo": "Point(4.07208 47.4519)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967896",
		"itemLabel": "château Hourtin-Ducasse"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967898",
		"itemLabel": "château Inférieur",
		"geo": "Point(2.13888889 44.49833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967904",
		"itemLabel": "château La Raz Caman",
		"geo": "Point(-0.64527778 45.21083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967920",
		"itemLabel": "château Laurens",
		"geo": "Point(3.47583 43.3108)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967924",
		"itemLabel": "château Le Lavouër",
		"geo": "Point(-0.814451 47.2729)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967927",
		"itemLabel": "château Les Vallées",
		"geo": "Point(0.93027778 46.77333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967942",
		"itemLabel": "château Maugiron",
		"geo": "Point(6.09694 48.1978)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967943",
		"itemLabel": "château Mennechet",
		"geo": "Point(2.94585 49.5462)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967949",
		"itemLabel": "château Montalembert",
		"geo": "Point(6.79904 47.2523)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967956",
		"itemLabel": "château Nolibos",
		"geo": "Point(-0.498333 43.8933)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967965",
		"itemLabel": "château Raoul",
		"geo": "Point(1.686 46.8125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967967",
		"itemLabel": "château Rivet",
		"geo": "Point(-0.516111 47.4377)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967977",
		"itemLabel": "château Saint-Clair",
		"geo": "Point(-1.65855 47.6857)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967987",
		"itemLabel": "château Saint-Sixte",
		"geo": "Point(6.48888889 49.27444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967990",
		"itemLabel": "château Sainte-Marguerite",
		"geo": "Point(5.6965 43.8028)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2967992",
		"itemLabel": "château Saulnier",
		"geo": "Point(0.72555556 45.47111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968001",
		"itemLabel": "château Thévenot",
		"geo": "Point(6.83747 47.4805)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968004",
		"itemLabel": "château Thomas II",
		"geo": "Point(5.86471 45.6517)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968009",
		"itemLabel": "château Trompette",
		"geo": "Point(0.29555556 45.22388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968014",
		"itemLabel": "château Vallombrosa",
		"geo": "Point(7.00493 43.5521)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968018",
		"itemLabel": "château Vieux de Jourgnac",
		"geo": "Point(1.21528 45.7181)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968022",
		"itemLabel": "château Vauclair",
		"geo": "Point(-1.15361 46.1625)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968023",
		"itemLabel": "château abbatial de Naussac",
		"geo": "Point(3.8382 44.729)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968025",
		"itemLabel": "château abbatial de Vézelay",
		"geo": "Point(3.74972 47.4661)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968026",
		"itemLabel": "château bas de Montjaux",
		"geo": "Point(2.89895 44.102)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968032",
		"itemLabel": "château d'Abondant",
		"geo": "Point(1.43681 48.784)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968041",
		"itemLabel": "château d'Ailly",
		"geo": "Point(-0.081917 48.942838)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968042",
		"itemLabel": "château d'Aillas",
		"geo": "Point(-0.06864 44.4773)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968043",
		"itemLabel": "château d'Agonac",
		"geo": "Point(0.75055556 45.29277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968044",
		"itemLabel": "château d'Airvault",
		"geo": "Point(-0.13806 46.8275)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968046",
		"itemLabel": "château d'Airoux",
		"geo": "Point(1.86629 43.3629)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968048",
		"itemLabel": "château d'Albigny-sur-Saône",
		"geo": "Point(4.83082 45.8665)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968049",
		"itemLabel": "château d'Albinhac",
		"geo": "Point(2.71825 44.8481)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968050",
		"itemLabel": "château d'Albon",
		"geo": "Point(4.87041667 45.24833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968054",
		"itemLabel": "château d'Alba-la-Romaine",
		"geo": "Point(4.59930556 44.55513889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968055",
		"itemLabel": "château d'Allemagne-en-Provence",
		"geo": "Point(6.00784 43.7833)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968056",
		"itemLabel": "château d'Allerey",
		"geo": "Point(4.98472 46.9061)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968057",
		"itemLabel": "château d'Allègre",
		"geo": "Point(3.71107 45.2017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968062",
		"itemLabel": "château d'Ambérieux-en-Dombes",
		"geo": "Point(4.90303 45.9971)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968063",
		"itemLabel": "château d'Amfreville",
		"geo": "Point(-1.38417 49.4153)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968066",
		"itemLabel": "château d'Amou",
		"geo": "Point(-0.745278 43.5953)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968068",
		"itemLabel": "château d'Ancinet",
		"geo": "Point(2.76934 46.3189)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968069",
		"itemLabel": "château d'Andelot",
		"geo": "Point(5.41548 46.4248)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968070",
		"itemLabel": "château d'Andert",
		"geo": "Point(5.66315 45.782)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968076",
		"itemLabel": "château d'Anglefort",
		"geo": "Point(5.81274 45.9132)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968077",
		"itemLabel": "château d'Angles-sur-l'Anglin",
		"geo": "Point(0.8831 46.6939)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968078",
		"itemLabel": "château d'Ancenis",
		"geo": "Point(-1.17667 47.3644)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968080",
		"itemLabel": "château d'Anizy",
		"geo": "Point(3.74325 46.9649)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968081",
		"itemLabel": "château d'Annéot",
		"geo": "Point(3.88265 47.5192)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968084",
		"itemLabel": "château d'Anserville",
		"geo": "Point(2.2078 49.2272)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968085",
		"itemLabel": "château d'Anstrude",
		"geo": "Point(4.18337 47.5958)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968087",
		"itemLabel": "château d'Anterroches",
		"geo": "Point(2.85222 45.1061)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968090",
		"itemLabel": "château d'Aragon",
		"geo": "Point(2.3141 43.2966)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968093",
		"itemLabel": "château d'Apcher",
		"geo": "Point(3.32222222 44.81638889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968095",
		"itemLabel": "château d'Arc",
		"geo": "Point(5.7686 47.0306)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968096",
		"itemLabel": "château d'Arcangues",
		"geo": "Point(-1.51701 43.436)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968099",
		"itemLabel": "château d'Arcine",
		"geo": "Point(6.37306 46.0606)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968100",
		"itemLabel": "château d'Arcelot",
		"geo": "Point(5.19305556 47.36888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968102",
		"itemLabel": "château d'Arcis-sur-Aube",
		"geo": "Point(4.14355 48.5378)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968109",
		"itemLabel": "château d'Argeliers",
		"geo": "Point(2.91167 43.3125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1326818",
		"itemLabel": "château de Miromesnil",
		"geo": "Point(1.0821 49.861)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1329976",
		"itemLabel": "citadelle de Besançon",
		"geo": "Point(6.0325 47.231389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1333377",
		"itemLabel": "château de Cordès",
		"geo": "Point(2.83947222 45.70233333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1333383",
		"itemLabel": "château de Montaigne",
		"geo": "Point(0.03 44.878333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1333422",
		"itemLabel": "château de Ravel",
		"geo": "Point(3.40028333 45.78269167)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1346520",
		"itemLabel": "château de Vixouze",
		"geo": "Point(2.59361111 44.94055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1376597",
		"itemLabel": "château de Troussay",
		"geo": "Point(1.424444 47.491389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1377160",
		"itemLabel": "château du Plessis-Bourré",
		"geo": "Point(-0.5444 47.601)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1405143",
		"itemLabel": "forteresse de Ham",
		"geo": "Point(3.0731 49.7434)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1436883",
		"itemLabel": "château de Maintenon",
		"geo": "Point(1.578055555 48.585555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1451798",
		"itemLabel": "château de Josselin",
		"geo": "Point(-2.5475 47.952361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1462683",
		"itemLabel": "château des Réaux",
		"geo": "Point(0.148055555 47.247777777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1470842",
		"itemLabel": "château de Sully-sur-Loire",
		"geo": "Point(2.3752 47.7677)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1479356",
		"itemLabel": "château de Talcy",
		"geo": "Point(1.444444444 47.769722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1484371",
		"itemLabel": "château du Sart",
		"geo": "Point(3.131952777 50.656783333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1493082",
		"itemLabel": "château d'Auzers",
		"geo": "Point(2.46166667 45.26444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1516747",
		"itemLabel": "château de Commarque",
		"geo": "Point(1.101944444 44.941666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1517348",
		"itemLabel": "château de Châteauneuf",
		"geo": "Point(4.64 47.2175)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1518981",
		"itemLabel": "château de Puymartin",
		"geo": "Point(1.1425 44.910555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1519303",
		"itemLabel": "château du Nideck",
		"geo": "Point(7.283055555 48.579722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1531552",
		"itemLabel": "château du Grand-Pressigny",
		"geo": "Point(0.80333333 46.92166667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1548218",
		"itemLabel": "château de Montrésor",
		"geo": "Point(1.20122222 47.15577778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1548414",
		"itemLabel": "château d'Azay-le-Ferron",
		"geo": "Point(1.07 46.851111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1552130",
		"itemLabel": "château de Bussy-Rabutin",
		"geo": "Point(4.523611 47.561389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1552366",
		"itemLabel": "château du Haut-Kœnigsbourg",
		"geo": "Point(7.344166666 48.249444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1557685",
		"itemLabel": "Guédelon",
		"geo": "Point(3.15583 47.58333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1561049",
		"itemLabel": "château de Bouteville",
		"geo": "Point(-0.135277777 45.600277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1569125",
		"itemLabel": "château de Baronville",
		"geo": "Point(1.731 48.448)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1626747",
		"itemLabel": "château de Meudon",
		"geo": "Point(2.231111111 48.805)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1635437",
		"itemLabel": "château de Bannegon",
		"geo": "Point(2.71555556 46.80213889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1648101",
		"itemLabel": "château de Brézé",
		"geo": "Point(-0.0575 47.174444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1649901",
		"itemLabel": "château de Thorens",
		"geo": "Point(6.25555556 45.99361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1650661",
		"itemLabel": "château de Combourg",
		"geo": "Point(-1.753888888 48.407777777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1652308",
		"itemLabel": "château de Hunebourg",
		"geo": "Point(7.36405556 48.83333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1661220",
		"itemLabel": "château de Val",
		"geo": "Point(2.50555556 45.44277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1666762",
		"itemLabel": "château de Lanquais",
		"geo": "Point(0.674166666 44.818888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1666762",
		"itemLabel": "château de Lanquais",
		"geo": "Point(0.67472222 44.81861111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1668992",
		"itemLabel": "château de Moret",
		"geo": "Point(2.818972 48.370825)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1670612",
		"itemLabel": "château de Saverne",
		"geo": "Point(7.363333333 48.742222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1676657",
		"itemLabel": "château de Chaban",
		"geo": "Point(1.06055556 45.01333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1676657",
		"itemLabel": "château de Chaban",
		"geo": "Point(1.06027778 45.01361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1727902",
		"itemLabel": "château de Jouffroy-d'Abbans",
		"geo": "Point(5.88194444 47.12194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1747134",
		"itemLabel": "château de l'Oedenbourg",
		"geo": "Point(7.33916667 48.24916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1764941",
		"itemLabel": "château de Pange",
		"geo": "Point(6.353843 49.083523)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1787326",
		"itemLabel": "château de Fougères-sur-Bièvre",
		"geo": "Point(1.343611111 47.447777777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1789926",
		"itemLabel": "château de Flers",
		"geo": "Point(3.132777777 50.635833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1790453",
		"itemLabel": "château du Spesbourg",
		"geo": "Point(7.397222222 48.401944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1800368",
		"itemLabel": "château d'Hattonchâtel",
		"geo": "Point(5.70583333 48.9925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1808663",
		"itemLabel": "château de Bayac",
		"geo": "Point(0.72888889 44.80388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1810332",
		"itemLabel": "château d'Acquigny",
		"geo": "Point(1.1875 49.17222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1814455",
		"itemLabel": "château de Segange",
		"geo": "Point(3.33722 46.5958)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1814732",
		"itemLabel": "château de Diedendorf",
		"geo": "Point(7.04694444 48.87805556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1815544",
		"itemLabel": "château de Châteaudun",
		"geo": "Point(1.323611111 48.070555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1815574",
		"itemLabel": "château de Biron",
		"geo": "Point(0.8725 44.632222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1815601",
		"itemLabel": "château de Montfort",
		"geo": "Point(1.249167 44.8375)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1817122",
		"itemLabel": "château d'Écouen",
		"geo": "Point(2.378333333 49.0175)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1818456",
		"itemLabel": "château du Vaudroc",
		"geo": "Point(0.5012 49.6836)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1819254",
		"itemLabel": "château de la Madeleine",
		"geo": "Point(1.4552 49.1231)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1821831",
		"itemLabel": "château de Pesteils",
		"geo": "Point(2.57527778 44.95333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1834237",
		"itemLabel": "château de Montréal",
		"geo": "Point(-1.10416667 43.54388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1847415",
		"itemLabel": "château de Berny",
		"geo": "Point(2.31278 48.7593)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1849405",
		"itemLabel": "château de Rosières",
		"geo": "Point(5.4036 47.4986)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1859459",
		"itemLabel": "château de La Brède",
		"geo": "Point(-0.544166666 44.679166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1862379",
		"itemLabel": "château d'Esparron-de-Verdon",
		"geo": "Point(5.97547 43.73901)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1865480",
		"itemLabel": "Bastille",
		"geo": "Point(2.369167 48.853333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1869481",
		"itemLabel": "château de Guise",
		"geo": "Point(3.623 49.896)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1870261",
		"itemLabel": "château de Bazouges",
		"geo": "Point(-0.167361111 47.687861111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1870453",
		"itemLabel": "château de Serrières",
		"geo": "Point(5.33111 45.6908)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1870948",
		"itemLabel": "château d'Aucors",
		"geo": "Point(0.48444444 45.48944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1876458",
		"itemLabel": "château des Rois ducs",
		"geo": "Point(1.0193 44.5911)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1880497",
		"itemLabel": "château de Lutzelbourg",
		"geo": "Point(7.25383333 48.73266667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1882287",
		"itemLabel": "château de Chaussins",
		"geo": "Point(3.47083 46.0878)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1886059",
		"itemLabel": "château de Verchant",
		"geo": "Point(3.90194 43.6369)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1887201",
		"itemLabel": "château de Lucinière",
		"geo": "Point(-1.46542 47.4831)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1888542",
		"itemLabel": "château de Savigny-lès-Beaune",
		"geo": "Point(4.81861 47.0617)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1895555",
		"itemLabel": "château de Fléchères",
		"geo": "Point(4.75833 46.0308)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1904744",
		"itemLabel": "château de Cypierre",
		"geo": "Point(4.19278 46.46)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1910237",
		"itemLabel": "château de Thillombois",
		"geo": "Point(5.3987 48.9565)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1919398",
		"itemLabel": "château de Doumely",
		"geo": "Point(4.305833333 49.63)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1925837",
		"itemLabel": "château d'Aon",
		"geo": "Point(-0.270833 43.8244)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1929031",
		"itemLabel": "château de Lormont",
		"geo": "Point(-0.52972222 44.87833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1938340",
		"itemLabel": "château Pichon",
		"geo": "Point(-0.597202 44.9403)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1959055",
		"itemLabel": "château de Rouen",
		"geo": "Point(1.094444444 49.446388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1959175",
		"itemLabel": "château de Cruzille",
		"geo": "Point(4.7925 46.5047)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1959338",
		"itemLabel": "château de Colombières",
		"geo": "Point(-0.97556 49.3031)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1975803",
		"itemLabel": "château de Lally",
		"geo": "Point(4.41583 47.0333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1980181",
		"itemLabel": "château de Condat",
		"geo": "Point(1.22888889 45.11694444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1985816",
		"itemLabel": "château d'Armentières",
		"geo": "Point(3.38261 49.1857)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1987156",
		"itemLabel": "château de Kérouzéré",
		"geo": "Point(-4.069722222 48.6725)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1988879",
		"itemLabel": "château des Étourneaux",
		"geo": "Point(2.58222 46.3468)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1989567",
		"itemLabel": "château de Gaillon",
		"geo": "Point(1.329722222 49.161111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1993975",
		"itemLabel": "château d'Ampuis",
		"geo": "Point(4.81326 45.4859)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1996196",
		"itemLabel": "château de Clérans",
		"geo": "Point(0.66666667 44.86277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1997741",
		"itemLabel": "château du Banchet",
		"geo": "Point(4.25556 46.2122)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2005028",
		"itemLabel": "château féodal de Sancerre",
		"geo": "Point(2.8408 47.3311)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2007231",
		"itemLabel": "château des Milandes",
		"geo": "Point(1.113333333 44.823611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2008408",
		"itemLabel": "château de Careil",
		"geo": "Point(-2.3987 47.2986)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2021453",
		"itemLabel": "château d'Aubenas",
		"geo": "Point(4.39058 44.6208)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2032524",
		"itemLabel": "château d'Anet",
		"geo": "Point(1.438611111 48.858055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2034453",
		"itemLabel": "château de Montcony",
		"geo": "Point(5.29121 46.7011)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970677",
		"itemLabel": "château de Septème",
		"geo": "Point(5.01083 45.5508)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970680",
		"itemLabel": "château de Sercy",
		"geo": "Point(4.68202 46.6055)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970682",
		"itemLabel": "château de Sermaizey",
		"geo": "Point(4.853166 46.646204)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970686",
		"itemLabel": "château de Serre-de-Parc",
		"geo": "Point(4.754274 44.589367)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970687",
		"itemLabel": "château de Serre",
		"geo": "Point(0.7028 46.1089)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970688",
		"itemLabel": "château de Serres",
		"geo": "Point(2.32278 42.9475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970689",
		"itemLabel": "château de Serveaux",
		"geo": "Point(-0.541954 46.9725)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970690",
		"itemLabel": "château de Serviès-en-Val",
		"geo": "Point(2.51925 43.0889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970691",
		"itemLabel": "château de Serviantin",
		"geo": "Point(5.80929 45.2344)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970696",
		"itemLabel": "château de Sigy-le-Châtel",
		"geo": "Point(4.57333333 46.55611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970699",
		"itemLabel": "château de Sillé-le-Guillaume",
		"geo": "Point(-0.126226 48.185)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970703",
		"itemLabel": "château de Sineuil",
		"geo": "Point(1.03731 44.6626)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970705",
		"itemLabel": "château de Sombacour",
		"geo": "Point(6.25778 46.9514)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970707",
		"itemLabel": "château de Somloire",
		"geo": "Point(-0.606855 47.0343)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970711",
		"itemLabel": "château de Sotteville",
		"geo": "Point(-1.7572 49.5472)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970713",
		"itemLabel": "château de Soucelles",
		"geo": "Point(-0.418114 47.5752)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970714",
		"itemLabel": "château de Souché",
		"geo": "Point(-1.6341 47.136)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970716",
		"itemLabel": "château de Soupir",
		"geo": "Point(3.60639 49.4067)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970718",
		"itemLabel": "château de Souvigny",
		"geo": "Point(3.19287 46.5358)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970727",
		"itemLabel": "château de Stors",
		"geo": "Point(2.20917 49.0897)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970731",
		"itemLabel": "château de Surgères",
		"geo": "Point(-0.7494 46.1064)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970734",
		"itemLabel": "château de Sédières",
		"geo": "Point(1.94972 45.2917)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970735",
		"itemLabel": "château de Sénergues",
		"geo": "Point(2.48556 44.6056)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970737",
		"itemLabel": "château de Suze-la-Rousse",
		"geo": "Point(4.83656 44.2874)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970739",
		"itemLabel": "château de Syam",
		"geo": "Point(5.945277777 46.704722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970741",
		"itemLabel": "château de Taisey",
		"geo": "Point(4.81688 46.7705)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970742",
		"itemLabel": "château de Suscinio",
		"geo": "Point(-2.729444444 47.512777777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970746",
		"itemLabel": "château de Talmay",
		"geo": "Point(5.43513 47.3563)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970755",
		"itemLabel": "château de Tancarville",
		"geo": "Point(0.464 49.484)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970756",
		"itemLabel": "château de Tardes",
		"geo": "Point(-0.22472222 44.56444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970757",
		"itemLabel": "château de Targé",
		"geo": "Point(0.5758 46.7889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970758",
		"itemLabel": "château de Tassigny",
		"geo": "Point(5.30703 49.6035)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970759",
		"itemLabel": "château de Tauriers",
		"geo": "Point(4.29139 44.5436)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970761",
		"itemLabel": "château de Tauzia",
		"geo": "Point(-0.616838 44.7613)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970762",
		"itemLabel": "château de Teillan",
		"geo": "Point(4.19107 43.6599)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970764",
		"itemLabel": "château de Tennessus",
		"geo": "Point(-0.278472 46.714)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970769",
		"itemLabel": "château de Tayac",
		"geo": "Point(1.01361111 44.93611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970771",
		"itemLabel": "château de Terrans",
		"geo": "Point(5.21611 46.8858)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970772",
		"itemLabel": "château de Terre Neuve",
		"geo": "Point(-0.814722 46.4628)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970773",
		"itemLabel": "château de Ternay",
		"geo": "Point(-0.04138889 47.03916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970774",
		"itemLabel": "château de Terzé",
		"geo": "Point(4.28861 46.4025)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970777",
		"itemLabel": "château de Theyrargues",
		"geo": "Point(4.28108 44.2277)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970778",
		"itemLabel": "château de Thierry",
		"geo": "Point(2.18639 48.8275)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970780",
		"itemLabel": "château de Terraube",
		"geo": "Point(0.552222222 43.905)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970781",
		"itemLabel": "château de Thil",
		"geo": "Point(4.33722222 47.385)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970782",
		"itemLabel": "château de Thizy",
		"geo": "Point(4.05416 47.5682)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970786",
		"itemLabel": "château de Thol",
		"geo": "Point(5.36821 46.066)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970788",
		"itemLabel": "château de Thomas Burnet",
		"geo": "Point(4.178 43.7219)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970790",
		"itemLabel": "château de Tholet",
		"geo": "Point(2.778108333 44.451497222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970794",
		"itemLabel": "château de Thorrenc",
		"geo": "Point(4.76178 45.2363)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970797",
		"itemLabel": "château de Thouaré",
		"geo": "Point(-1.4436 47.261)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970801",
		"itemLabel": "château de Thugny-Trugny",
		"geo": "Point(4.42053 49.4852)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970802",
		"itemLabel": "château de Thoury",
		"geo": "Point(3.64028 46.48)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970803",
		"itemLabel": "château de Thuillières",
		"geo": "Point(6.0083 48.155)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970808",
		"itemLabel": "château de Tilloloy",
		"geo": "Point(2.74484 49.6456)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970809",
		"itemLabel": "château de Tilly",
		"geo": "Point(0.7865 49.2744)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970811",
		"itemLabel": "château de Tocqueville",
		"geo": "Point(-1.32931 49.6669)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970815",
		"itemLabel": "château de Torcy",
		"geo": "Point(4.45861 46.7725)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970817",
		"itemLabel": "château de Tornac",
		"geo": "Point(3.9979 44.036)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970820",
		"itemLabel": "château de Torpes",
		"geo": "Point(5.89299 47.1705)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970822",
		"itemLabel": "château de Toulongergues",
		"geo": "Point(2.02703 44.4044)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970823",
		"itemLabel": "château de Toulonjac",
		"geo": "Point(1.9997 44.3826)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970827",
		"itemLabel": "château de Tourette-Levens",
		"geo": "Point(7.27649 43.7836)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970828",
		"itemLabel": "château de Tournin",
		"geo": "Point(5.44156 45.5585)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970830",
		"itemLabel": "château de Tournon (Savoie)",
		"geo": "Point(6.31611 45.6431)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970834",
		"itemLabel": "château de Tramezaygues",
		"geo": "Point(0.286861 42.7972)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970841",
		"itemLabel": "château de Triadou",
		"geo": "Point(3.2063 44.1881)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970843",
		"itemLabel": "château de Trie",
		"geo": "Point(1.8215 49.2851)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970846",
		"itemLabel": "château de Troissereux",
		"geo": "Point(2.03981 49.4773)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970849",
		"itemLabel": "château de Trousseau",
		"geo": "Point(2.42827 48.6506)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970857",
		"itemLabel": "château de Trélague",
		"geo": "Point(4.21778 46.784)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970862",
		"itemLabel": "château de Trémohar",
		"geo": "Point(-2.56611 47.6339)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970863",
		"itemLabel": "château de Trévoux",
		"geo": "Point(4.7745 45.9433)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970864",
		"itemLabel": "château de Turenne",
		"geo": "Point(1.58361111 45.05555556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970867",
		"itemLabel": "château de Trécesson",
		"geo": "Point(-2.273888888 47.975555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970868",
		"itemLabel": "château de Turenne",
		"geo": "Point(4.973333333 49.676666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970878",
		"itemLabel": "château de Val-Seille",
		"geo": "Point(4.88306 44.09)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970879",
		"itemLabel": "château de Vaire-le-Grand",
		"geo": "Point(6.1502 47.2837)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970884",
		"itemLabel": "château de Vallabrix",
		"geo": "Point(4.4785 44.0599)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970885",
		"itemLabel": "château de Valdonne",
		"geo": "Point(5.58518 43.3812)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970886",
		"itemLabel": "château de Vallauris",
		"geo": "Point(7.05345 43.58)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970887",
		"itemLabel": "château de Vallerois-le-Bois",
		"geo": "Point(6.28667 47.5489)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970888",
		"itemLabel": "château de Valliguières",
		"geo": "Point(4.5792 44.0074)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970891",
		"itemLabel": "château de Vallière",
		"geo": "Point(2.61222 49.1231)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970892",
		"itemLabel": "château de Vallon-Pont-d'Arc",
		"geo": "Point(4.39501 44.4071)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970893",
		"itemLabel": "château de Vallery",
		"geo": "Point(3.050555555 48.241388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970894",
		"itemLabel": "château de Valmirande",
		"geo": "Point(0.54028 43.085)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970897",
		"itemLabel": "château de Valon",
		"geo": "Point(2.6325 44.7361)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970898",
		"itemLabel": "château de Valrose",
		"geo": "Point(7.26583 43.7158)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970899",
		"itemLabel": "château de Vandenesse",
		"geo": "Point(3.76028 46.9103)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970900",
		"itemLabel": "château de Vanlay",
		"geo": "Point(4.01166 48.0241)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970902",
		"itemLabel": "château de Varambon",
		"geo": "Point(5.31379 46.0405)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970903",
		"itemLabel": "château de Varax",
		"geo": "Point(5.14275 46.0997)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970907",
		"itemLabel": "château de Varepe",
		"geo": "Point(5.57722 45.7195)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970908",
		"itemLabel": "château de Varey",
		"geo": "Point(5.40454 46.0267)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970911",
		"itemLabel": "château de Vassy",
		"geo": "Point(3.911106 47.535475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970917",
		"itemLabel": "château de Vaugrenier Translation",
		"geo": "Point(7.11887 43.6301)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970918",
		"itemLabel": "château de Vauguillain",
		"geo": "Point(3.29462 48.0271)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970919",
		"itemLabel": "château de Vaucocour",
		"geo": "Point(0.92194444 45.41444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970920",
		"itemLabel": "château de Vaugoubert",
		"geo": "Point(0.69638889 45.42444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q10945",
		"itemLabel": "château de Beauregard",
		"geo": "Point(4.78768 45.6931)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q11906",
		"itemLabel": "tour Barberousse",
		"geo": "Point(3.084444444 43.107777777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q45677",
		"itemLabel": "château de Choisy-le-Roi",
		"geo": "Point(2.408826 48.762948)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q113389",
		"itemLabel": "château d'Azay-le-Rideau",
		"geo": "Point(0.466111111 47.259166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q125814",
		"itemLabel": "château de Germolles",
		"geo": "Point(4.751388888 46.805833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q138101",
		"itemLabel": "conciergerie de Paris",
		"geo": "Point(2.345555555 48.856388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q154750",
		"itemLabel": "château de Montpensier"
	},
	{
		"item": "http://www.wikidata.org/entity/Q159147",
		"itemLabel": "château d'Aubeterre",
		"geo": "Point(0.17056 45.2719)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q164901",
		"itemLabel": "château de Montgilbert",
		"geo": "Point(3.623527777 46.038527777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q179549",
		"itemLabel": "château de Rothenbourg",
		"geo": "Point(7.57555556 49.024615)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q185479",
		"itemLabel": "château d'Ussé",
		"geo": "Point(0.291111111 47.249722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q186575",
		"itemLabel": "château de Filières",
		"geo": "Point(0.372238888 49.561616666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q193215",
		"itemLabel": "château de Chenonceau",
		"geo": "Point(1.0706 47.325)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q202249",
		"itemLabel": "château-Rocher",
		"geo": "Point(2.9281998 46.0891564)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q205367",
		"itemLabel": "château de Chambord",
		"geo": "Point(1.516962 47.616342)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q205659",
		"itemLabel": "château de Lunéville",
		"geo": "Point(6.4925 48.594722)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q281285",
		"itemLabel": "château de Sassy",
		"geo": "Point(8.3E-4 48.6556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q282646",
		"itemLabel": "château de Saint-Ulrich",
		"geo": "Point(7.305277777 48.2025)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q284234",
		"itemLabel": "château de la Chétardie",
		"geo": "Point(0.6694 45.8836)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q289894",
		"itemLabel": "château de Branzac",
		"geo": "Point(2.32388889 45.11277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q312445",
		"itemLabel": "château de Dinan",
		"geo": "Point(-2.044888888 48.450277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q429691",
		"itemLabel": "château de Wideville",
		"geo": "Point(1.9355 48.8719)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q477341",
		"itemLabel": "château de Chanteloup",
		"geo": "Point(0.97 47.390972222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q477613",
		"itemLabel": "château de Villandry",
		"geo": "Point(0.512777777 47.340555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q507020",
		"itemLabel": "palais des Rois de Majorque",
		"geo": "Point(2.895555555 42.693888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q509632",
		"itemLabel": "château de Montjalin",
		"geo": "Point(3.941666666 47.5175)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q511492",
		"itemLabel": "château de Commarin",
		"geo": "Point(4.648713888 47.255447222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q338711",
		"itemLabel": "château de Luc",
		"geo": "Point(3.889166666 44.652222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q370664",
		"itemLabel": "châteaux de Lastours",
		"geo": "Point(2.378333333 43.336388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q371491",
		"itemLabel": "château de Pusignan",
		"geo": "Point(5.06111111 45.75319444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q374565",
		"itemLabel": "château de Kerguéhennec",
		"geo": "Point(-2.7345 47.8859)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q376603",
		"itemLabel": "château de Passy-les-Tours",
		"geo": "Point(3.07583333 47.21527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q376699",
		"itemLabel": "château de Pierrefonds",
		"geo": "Point(2.980278 49.346944)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q378453",
		"itemLabel": "château de Malbrouck",
		"geo": "Point(6.432777777 49.457222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q382628",
		"itemLabel": "Rocamadour",
		"geo": "Point(1.617777777 44.799444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q386009",
		"itemLabel": "château de Morlanne",
		"geo": "Point(-0.535555555 43.51)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q389269",
		"itemLabel": "cité de Carcassonne",
		"geo": "Point(2.363788 43.206439)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q389908",
		"itemLabel": "château d'Amboise",
		"geo": "Point(0.985833333 47.413055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q425789",
		"itemLabel": "château de Castelnau-Bretenoux",
		"geo": "Point(1.8264 44.8992)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q428854",
		"itemLabel": "château de la Roche-Courbon",
		"geo": "Point(-0.781388888 45.836111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q429529",
		"itemLabel": "château de Fallavier",
		"geo": "Point(5.1225 45.62777778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q522779",
		"itemLabel": "château de Chaumont-sur-Loire",
		"geo": "Point(1.181944444 47.479166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q530673",
		"itemLabel": "château de Gannat",
		"geo": "Point(3.196666666 46.101388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q539485",
		"itemLabel": "Roquemartine",
		"geo": "Point(5.03277778 43.71527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q541130",
		"itemLabel": "fort de Bertheaume",
		"geo": "Point(-4.6975 48.33694444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q542693",
		"itemLabel": "château de Tiregand",
		"geo": "Point(0.55055556 44.85611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q574056",
		"itemLabel": "château de Cormatin",
		"geo": "Point(4.684277777 46.543138888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q576534",
		"itemLabel": "château de Coucy",
		"geo": "Point(3.31861111 49.52166667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q576569",
		"itemLabel": "château de Beauregard",
		"geo": "Point(1.383611 47.536944)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q577444",
		"itemLabel": "château de Champlâtreux",
		"geo": "Point(2.41108 49.0858)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q577783",
		"itemLabel": "château de La Palice",
		"geo": "Point(3.63833333 46.24861111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q577915",
		"itemLabel": "château de Ramstein",
		"geo": "Point(7.38861111 48.29444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q579961",
		"itemLabel": "château d'Ancy-le-Franc",
		"geo": "Point(4.161666666 47.773888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q580512",
		"itemLabel": "château des Chances",
		"geo": "Point(4.71666667 45.51666667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q582885",
		"itemLabel": "château du Haut Rosay",
		"geo": "Point(1.68016 48.9125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q584950",
		"itemLabel": "château de Corcelle",
		"geo": "Point(4.63916667 46.36305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q600832",
		"itemLabel": "château de Goulaine",
		"geo": "Point(-1.402777777 47.204166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q606724",
		"itemLabel": "château Faugas",
		"geo": "Point(-0.25944444 44.61861111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q608624",
		"itemLabel": "château de Courtanvaux",
		"geo": "Point(0.735556 47.8442)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q608801",
		"itemLabel": "château de la Roche",
		"geo": "Point(0.62055556 45.19222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012942",
		"itemLabel": "château de Lichtenberg",
		"geo": "Point(7.487222222 48.921111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013050",
		"itemLabel": "château de Lusignan",
		"geo": "Point(0.127777777 46.437222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012796",
		"itemLabel": "château de la Hunaudaye",
		"geo": "Point(-2.339 48.472805555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012812",
		"itemLabel": "château de Lagarde",
		"geo": "Point(1.935694444 43.050555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012838",
		"itemLabel": "château du Landsberg",
		"geo": "Point(7.4225 48.42055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012864",
		"itemLabel": "château de Langoiran",
		"geo": "Point(-0.3817 44.6991)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012883",
		"itemLabel": "château de Laval",
		"geo": "Point(-0.77119444 48.06872222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012889",
		"itemLabel": "château de Lavardin",
		"geo": "Point(0.883333333 47.740833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013993",
		"itemLabel": "château de Sedan",
		"geo": "Point(4.949444444 49.701944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013141",
		"itemLabel": "château de Montaillou",
		"geo": "Point(1.894154 42.787024)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013143",
		"itemLabel": "château de Montguerlhe",
		"geo": "Point(3.59777778 45.83333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013167",
		"itemLabel": "château de Murol",
		"geo": "Point(2.945278 45.578333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013191",
		"itemLabel": "château de Montségur",
		"geo": "Point(1.8325 42.875555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013196",
		"itemLabel": "château de Najac",
		"geo": "Point(1.973333333 44.218333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013499",
		"itemLabel": "château de Pierregourde",
		"geo": "Point(4.73833333 44.84722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013503",
		"itemLabel": "château de Pirou",
		"geo": "Point(-1.57361111 49.16138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013511",
		"itemLabel": "château de Poissy",
		"geo": "Point(2.04194444 48.92861111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013541",
		"itemLabel": "château de Puilaurens",
		"geo": "Point(2.299444444 42.80375)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013622",
		"itemLabel": "château de Regnéville",
		"geo": "Point(-1.553055555 49.0075)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013727",
		"itemLabel": "château de Roquebrune-Cap-Martin",
		"geo": "Point(7.45968056 43.76523889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013738",
		"itemLabel": "château de Roquefixade",
		"geo": "Point(1.753333333 42.938888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013802",
		"itemLabel": "château de Sagonne",
		"geo": "Point(2.82625 46.85)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013813",
		"itemLabel": "château de Sales",
		"geo": "Point(6.25833333 45.99444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1013823",
		"itemLabel": "château de Salignac",
		"geo": "Point(1.326666666 44.974861111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1061061",
		"itemLabel": "château de Loches",
		"geo": "Point(0.998333333 47.126944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1067494",
		"itemLabel": "Tour du Temple",
		"geo": "Point(2.36222 48.86528)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1088203",
		"itemLabel": "château de Pourtalès",
		"geo": "Point(7.8 48.60833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1090492",
		"itemLabel": "château Gaillard",
		"geo": "Point(1.402752777 49.238127777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1090706",
		"itemLabel": "fort de Joux",
		"geo": "Point(6.373611111 46.872777777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1090706",
		"itemLabel": "fort de Joux",
		"geo": "Point(6.3742 46.8725)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1090716",
		"itemLabel": "château de Rayne-Vigneau",
		"geo": "Point(-0.344722222 44.5475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1090719",
		"itemLabel": "château du Hâ",
		"geo": "Point(-0.5794 44.8364)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1090764",
		"itemLabel": "château d'Yquem",
		"geo": "Point(-0.328683 44.5436)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1105327",
		"itemLabel": "château de Vilhonneur",
		"geo": "Point(0.42083 45.6811)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1117166",
		"itemLabel": "château d'Haroué",
		"geo": "Point(6.18 48.465555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1122731",
		"itemLabel": "château du Clos Lucé",
		"geo": "Point(0.991388888 47.41)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1125842",
		"itemLabel": "château de la Verrerie",
		"geo": "Point(2.52194444 47.42294444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1129728",
		"itemLabel": "château du Pflixbourg",
		"geo": "Point(7.254444444 48.067222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1141846",
		"itemLabel": "château de Cheverny",
		"geo": "Point(1.458055555 47.500277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1143049",
		"itemLabel": "château de Montsoreau",
		"geo": "Point(0.0622 47.2156)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1143558",
		"itemLabel": "château de Langeais",
		"geo": "Point(0.4061 47.3248)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1150222",
		"itemLabel": "château de Saumur",
		"geo": "Point(-0.0725 47.256111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1157384",
		"itemLabel": "château de Dagsbourg",
		"geo": "Point(7.272949 48.039244)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1192381",
		"itemLabel": "château de Menars",
		"geo": "Point(1.4104 47.6388)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1230965",
		"itemLabel": "château de La Roche-Guyon",
		"geo": "Point(1.628055555 49.081111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1236468",
		"itemLabel": "château de Sassenage",
		"geo": "Point(5.65936111 45.21069444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1256985",
		"itemLabel": "Les Trois Châteaux",
		"geo": "Point(7.272777777 48.038611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1264866",
		"itemLabel": "château de la Ferté de La Ferté-Saint-Aubin",
		"geo": "Point(1.9432712 47.7264643)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1289258",
		"itemLabel": "château des ducs de Bretagne",
		"geo": "Point(-1.55 47.215833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1318314",
		"itemLabel": "château d'Ainay-le-Vieil",
		"geo": "Point(2.54972222 46.66819444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011343",
		"itemLabel": "château de Castelbouc",
		"geo": "Point(3.464298 44.339983)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011357",
		"itemLabel": "château de Castelnaud",
		"geo": "Point(1.148889 44.815833)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011361",
		"itemLabel": "château de Châlus-Chabrol",
		"geo": "Point(0.980277777 45.655)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011384",
		"itemLabel": "château de Couzan",
		"geo": "Point(3.969166666 45.728055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011390",
		"itemLabel": "château de Clisson",
		"geo": "Point(-1.28083333 47.08666667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011395",
		"itemLabel": "tour de Crest",
		"geo": "Point(5.023646 44.730281)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011401",
		"itemLabel": "château de Crussol",
		"geo": "Point(4.8525 44.938333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011407",
		"itemLabel": "château de Culan",
		"geo": "Point(2.352222222 46.546388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011471",
		"itemLabel": "château de Dieppe",
		"geo": "Point(1.07026 49.92473)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011487",
		"itemLabel": "château de Dourdan",
		"geo": "Point(2.010833333 48.53)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011692",
		"itemLabel": "château de Falaise",
		"geo": "Point(-0.2039 48.8932)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011806",
		"itemLabel": "château de Foix",
		"geo": "Point(1.605 42.965555555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011967",
		"itemLabel": "château du Girsberg",
		"geo": "Point(7.30722222 48.20361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011980",
		"itemLabel": "château de Guirbaden",
		"geo": "Point(7.370277777 48.493611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1011985",
		"itemLabel": "château de Gisors",
		"geo": "Point(1.7745 49.2808)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012421",
		"itemLabel": "château de Hohenfels",
		"geo": "Point(7.613888888 49.003055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012467",
		"itemLabel": "château du Haut-Ribeaupierre",
		"geo": "Point(7.30545 48.20625)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1012510",
		"itemLabel": "château du Hugstein",
		"geo": "Point(7.19205556 47.92085833)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1014245",
		"itemLabel": "château de Termes",
		"geo": "Point(2.556666666 43.002222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1014264",
		"itemLabel": "château de Tournoël",
		"geo": "Point(3.03833333 45.88486111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1014269",
		"itemLabel": "château de Tonquédec",
		"geo": "Point(-3.411666666 48.676666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1014308",
		"itemLabel": "château de Turquestein",
		"geo": "Point(7.03930556 48.58808333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1014314",
		"itemLabel": "château de Trémazan",
		"geo": "Point(-4.712222222 48.550833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1014374",
		"itemLabel": "château de Vendôme",
		"geo": "Point(1.065765 47.789283)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1014396",
		"itemLabel": "château de Villerouge-Termenès",
		"geo": "Point(2.62666667 43.006875)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1014628",
		"itemLabel": "château du Wineck",
		"geo": "Point(7.27813661 48.10924366)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1014739",
		"itemLabel": "château d'Étampes",
		"geo": "Point(2.158333333 48.437222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q1028251",
		"itemLabel": "château de Grosbois",
		"geo": "Point(2.5275 48.73527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2420868",
		"itemLabel": "château de Filain",
		"geo": "Point(6.18461 47.5178)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2420900",
		"itemLabel": "château de Sainte-Pallaye",
		"geo": "Point(3.66931 47.6475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971919",
		"itemLabel": "châteaux de Mello",
		"geo": "Point(2.36861 49.2672)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2784457",
		"itemLabel": "château de Tramayes",
		"geo": "Point(4.60306 46.3069)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2794879",
		"itemLabel": "château de Saint-Geniès",
		"geo": "Point(1.25055556 44.99416667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2795436",
		"itemLabel": "château de La Tour",
		"geo": "Point(4.7929 45.6936)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970463",
		"itemLabel": "château de Rustéphan",
		"geo": "Point(-3.767222222 47.858888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2040732",
		"itemLabel": "château de Palaminy",
		"geo": "Point(1.06778 43.2019)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2044804",
		"itemLabel": "château de Prény",
		"geo": "Point(5.9951 48.9786)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968111",
		"itemLabel": "château d'Arfeuille",
		"geo": "Point(2.20639 45.8822)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968112",
		"itemLabel": "château d'Arginy",
		"geo": "Point(4.68948 46.083)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968115",
		"itemLabel": "château d'Arlay",
		"geo": "Point(5.5379 46.759)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968121",
		"itemLabel": "château d'Arnay-le-Duc",
		"geo": "Point(4.48519 47.1296)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968122",
		"itemLabel": "château d'Arnicourt",
		"geo": "Point(4.35264 49.555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968124",
		"itemLabel": "château d'Arnouville",
		"geo": "Point(2.41867 48.9798)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968125",
		"itemLabel": "château d'Arranceau",
		"geo": "Point(3.75726 49.4924)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968126",
		"itemLabel": "château d'Arrancy",
		"geo": "Point(3.75729 49.4925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968127",
		"itemLabel": "château d'Arrentières",
		"geo": "Point(4.74373 48.2601)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968129",
		"itemLabel": "château d'Arques-la-Bataille",
		"geo": "Point(1.127054 49.877235)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968130",
		"itemLabel": "château d'Arry",
		"geo": "Point(6.0569 48.9961)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968131",
		"itemLabel": "château d'Ars",
		"geo": "Point(-0.39 45.6458)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968132",
		"itemLabel": "château d'Ars",
		"geo": "Point(2.00449 46.6024)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968135",
		"itemLabel": "château d'Artangues",
		"geo": "Point(3.22425 46.2707)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968137",
		"itemLabel": "château d'Arçon",
		"geo": "Point(3.10425 46.1308)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968141",
		"itemLabel": "château d'Arzens",
		"geo": "Point(2.20972 43.1999)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968142",
		"itemLabel": "château d'Assas",
		"geo": "Point(3.6052 43.9901)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968144",
		"itemLabel": "château d'Athis",
		"geo": "Point(2.39062 48.7087)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968147",
		"itemLabel": "château d'Aubais",
		"geo": "Point(4.1458 43.7539)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968152",
		"itemLabel": "château d'Aubigné",
		"geo": "Point(-0.461683 47.2136)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968154",
		"itemLabel": "château d'Aubonne",
		"geo": "Point(6.3283 47.035)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968155",
		"itemLabel": "château d'Audrieu",
		"geo": "Point(-0.5944 49.204)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968157",
		"itemLabel": "château d'Auberoche",
		"geo": "Point(0.89583333 45.20888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968158",
		"itemLabel": "château d'Auflance",
		"geo": "Point(5.29099 49.6177)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968159",
		"itemLabel": "château d'Aulan",
		"geo": "Point(5.42834 44.2223)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968163",
		"itemLabel": "château d'Augerville",
		"geo": "Point(2.43871 48.25143)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968164",
		"itemLabel": "château d'Aulnois-sous-Laon",
		"geo": "Point(3.60139 49.6125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968167",
		"itemLabel": "château d'Aumelas",
		"geo": "Point(3.60882 43.5977)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968168",
		"itemLabel": "château d'Auriac",
		"geo": "Point(2.49361111 42.93805556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968169",
		"itemLabel": "château d'Auteuil",
		"geo": "Point(2.07787 49.3486)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968170",
		"itemLabel": "château d'Aurouze",
		"geo": "Point(3.14154 45.2396)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968173",
		"itemLabel": "château d'Authon",
		"geo": "Point(-0.403889 45.8353)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968174",
		"itemLabel": "château d'Autry",
		"geo": "Point(2.0403 47.1969)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968175",
		"itemLabel": "château d'Auvers",
		"geo": "Point(2.16624 49.0719)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968176",
		"itemLabel": "château d'Auxonne",
		"geo": "Point(5.38333 47.1917)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968179",
		"itemLabel": "château d'Auzon",
		"geo": "Point(3.372222222 45.391666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968181",
		"itemLabel": "château d'Avigneau",
		"geo": "Point(3.48548 47.7137)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968184",
		"itemLabel": "château d'Avignon",
		"geo": "Point(4.40947 43.5587)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968185",
		"itemLabel": "château d'Avrilly",
		"geo": "Point(3.28847 46.6395)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968190",
		"itemLabel": "château d'Eaucourt-sur-Somme",
		"geo": "Point(1.88278 50.0611)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968196",
		"itemLabel": "château d'Eck",
		"geo": "Point(-0.53916667 44.74416667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968197",
		"itemLabel": "château d'Einartzhausen",
		"geo": "Point(7.26092 48.7656)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968201",
		"itemLabel": "château d'Engayresque",
		"geo": "Point(3.0721 44.2671)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968202",
		"itemLabel": "château d'Eliçabéa",
		"geo": "Point(-0.8775 43.1311)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968203",
		"itemLabel": "château d'Entraigues",
		"geo": "Point(2.25139 44.7542)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968205",
		"itemLabel": "château d'Entrevaux",
		"geo": "Point(6.81333 43.9525)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968207",
		"itemLabel": "château d'Epiry",
		"geo": "Point(4.497 46.8814)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968213",
		"itemLabel": "château d'Escoire",
		"geo": "Point(0.84639 45.2061)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968216",
		"itemLabel": "château d'Escorailles",
		"geo": "Point(2.32944 45.1747)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968218",
		"itemLabel": "château d'Escurolles",
		"geo": "Point(3.26428 46.1421)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968220",
		"itemLabel": "château d'Esnes",
		"geo": "Point(3.30944444 50.11111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968222",
		"itemLabel": "château d'Esnon",
		"geo": "Point(3.57774 47.9882)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968224",
		"itemLabel": "château d'Espeyran",
		"geo": "Point(4.4036 43.6439)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968228",
		"itemLabel": "château d'Essalois",
		"geo": "Point(4.24583333 45.46222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968229",
		"itemLabel": "château d'Essertaux",
		"geo": "Point(2.23972 49.7408)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968230",
		"itemLabel": "château d'Estaing",
		"geo": "Point(2.672791666 44.553897222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968231",
		"itemLabel": "château d'Estang",
		"geo": "Point(2.47167 45.0003)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968234",
		"itemLabel": "château d'Estours",
		"geo": "Point(4.79 46.2408)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968237",
		"itemLabel": "château d'Eyjeaux",
		"geo": "Point(1.39291 45.7775)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968241",
		"itemLabel": "château d'Eyliac",
		"geo": "Point(0.853888888 45.161333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968244",
		"itemLabel": "château d'Harzillemont",
		"geo": "Point(4.58709 49.6107)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968246",
		"itemLabel": "château d'Hauterive",
		"geo": "Point(3.39781 46.4096)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968250",
		"itemLabel": "château d'Harcourt",
		"geo": "Point(0.786388888 49.173888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968254",
		"itemLabel": "château d'Helfedange",
		"geo": "Point(6.53 49.081111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968256",
		"itemLabel": "château d'Heudicourt",
		"geo": "Point(1.66034 49.336)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968257",
		"itemLabel": "château d'Hommes",
		"geo": "Point(0.2975 47.4267)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968259",
		"itemLabel": "château d'Hodebert",
		"geo": "Point(0.466479 47.6045)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968260",
		"itemLabel": "château d'Honoré d'Urfé",
		"geo": "Point(5.648634 45.848373)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968262",
		"itemLabel": "château d'Hénonville",
		"geo": "Point(2.05333 49.2064)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968263",
		"itemLabel": "château d'Hérisson",
		"geo": "Point(2.71297 46.5091)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968264",
		"itemLabel": "château d'Héré",
		"geo": "Point(6.19768 45.8237)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968265",
		"itemLabel": "château d'Hérouville",
		"geo": "Point(2.13305556 49.10166667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968266",
		"itemLabel": "château d'Idogne",
		"geo": "Point(3.271 46.1248)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968280",
		"itemLabel": "château d'Irigny",
		"geo": "Point(4.82306 45.6725)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968284",
		"itemLabel": "château d'Issards",
		"geo": "Point(3.14144 46.5299)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968287",
		"itemLabel": "château d'Ivry-la-Bataille",
		"geo": "Point(1.457 48.885)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968299",
		"itemLabel": "château d'Ognon",
		"geo": "Point(2.6419 49.2379)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968302",
		"itemLabel": "château d'Oigny-en-Valois",
		"geo": "Point(3.137777777 49.219444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968304",
		"itemLabel": "château d'Olivet",
		"geo": "Point(-0.427394 49.0428)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968306",
		"itemLabel": "château d'Ollans",
		"geo": "Point(6.2425 47.419)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968308",
		"itemLabel": "château d'Ombreval",
		"geo": "Point(4.8401 45.8778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968309",
		"itemLabel": "château d'Onet-le-Château",
		"geo": "Point(2.53912 44.3909)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968313",
		"itemLabel": "château d'Ordières",
		"geo": "Point(0.47333 46.0503)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968314",
		"itemLabel": "château d'Ordon",
		"geo": "Point(3.16871 48.0203)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968318",
		"itemLabel": "château d'Oricourt",
		"geo": "Point(6.391944444 47.595833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968321",
		"itemLabel": "château d'Orrouy",
		"geo": "Point(2.85927 49.2928)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968323",
		"itemLabel": "château d'Orschwihr",
		"geo": "Point(7.23453 47.9352)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968327",
		"itemLabel": "château d'Oudon",
		"geo": "Point(-1.28922 47.3455)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968329",
		"itemLabel": "château d'Osthoffen",
		"geo": "Point(7.553333 48.584167)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968331",
		"itemLabel": "château d'Oyez",
		"geo": "Point(2.51694 44.9767)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968335",
		"itemLabel": "château d'Ozenay",
		"geo": "Point(4.84861 46.5425)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968337",
		"itemLabel": "château d'Ultrera",
		"geo": "Point(2.97917 42.5156)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968341",
		"itemLabel": "château d'Urtubie",
		"geo": "Point(-1.68833 43.3667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968345",
		"itemLabel": "château d'Usson",
		"geo": "Point(-0.536944 45.5686)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968349",
		"itemLabel": "château d'Yrouerre",
		"geo": "Point(3.94793 47.7943)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968350",
		"itemLabel": "château d'Usson",
		"geo": "Point(2.0875 42.73555556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968354",
		"itemLabel": "château d'eau-marégraphe",
		"geo": "Point(1.07833 49.4417)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968357",
		"itemLabel": "château d'eau d'Hérouville-Saint-Clair",
		"geo": "Point(-0.342317 49.2028)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968358",
		"itemLabel": "château d'eau de Brive",
		"geo": "Point(1.53383 45.1619)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968359",
		"itemLabel": "château d'eau de Colmar",
		"geo": "Point(7.35271 48.0712)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2054341",
		"itemLabel": "château de Saché",
		"geo": "Point(0.544444 47.245833)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2056655",
		"itemLabel": "château de Blérancourt",
		"geo": "Point(3.1547 49.5179)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2059782",
		"itemLabel": "Petit Châtelet",
		"geo": "Point(2.347222222 48.8575)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2060046",
		"itemLabel": "château de Roquetaillade",
		"geo": "Point(-0.277777777 44.494744444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2060454",
		"itemLabel": "château de Clauzuroux",
		"geo": "Point(0.355833333 45.409722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2062506",
		"itemLabel": "château de Bresse-sur-Grosne",
		"geo": "Point(4.74111 46.5925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2068180",
		"itemLabel": "château de Trévarez",
		"geo": "Point(-3.80667 48.1528)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2068910",
		"itemLabel": "château de Cherveux",
		"geo": "Point(-0.355704 46.4165)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2072054",
		"itemLabel": "château de l'Épine",
		"geo": "Point(3.15778 46.6458)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2075590",
		"itemLabel": "château de Gœulzin",
		"geo": "Point(3.0916 50.3173)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2084520",
		"itemLabel": "château de Laroque",
		"geo": "Point(3.72379 43.9225)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2085869",
		"itemLabel": "château de Vascœuil",
		"geo": "Point(1.3789 49.4467)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2085994",
		"itemLabel": "château de Beaurepaire-en-Bresse",
		"geo": "Point(5.3825 46.6672)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2090110",
		"itemLabel": "château du Prada",
		"geo": "Point(-0.18527778 43.96833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2090672",
		"itemLabel": "château de Bonneville",
		"geo": "Point(0.5496 48.9872)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2090800",
		"itemLabel": "château d'Yville",
		"geo": "Point(0.878311 49.3973)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2093669",
		"itemLabel": "château de Lissieu",
		"geo": "Point(4.74278 45.8656)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2094518",
		"itemLabel": "château des archevêques de Narbonne",
		"geo": "Point(3.04544 43.3284)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2095479",
		"itemLabel": "château de Clermont",
		"geo": "Point(-1.333888888 47.325277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2097589",
		"itemLabel": "château de Mavaleix",
		"geo": "Point(0.9589 45.504305555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2104550",
		"itemLabel": "château de Lamartinie",
		"geo": "Point(2.40056 44.9192)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2121153",
		"itemLabel": "château de Fontaine-Française",
		"geo": "Point(5.36854 47.5269)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2128921",
		"itemLabel": "château de l'Empéri",
		"geo": "Point(5.097222222 43.639444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2129936",
		"itemLabel": "château de la Lande",
		"geo": "Point(3.056666666 46.452222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2132248",
		"itemLabel": "château Levat",
		"geo": "Point(3.88943 43.6229)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2137176",
		"itemLabel": "château de Grammont",
		"geo": "Point(4.2111 46.4114)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2142824",
		"itemLabel": "château de Rougemont",
		"geo": "Point(6.966837 47.747939)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2150238",
		"itemLabel": "château de la Jarthe",
		"geo": "Point(0.62611111 45.12833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2154496",
		"itemLabel": "château de La Gallée",
		"geo": "Point(4.78944 45.6294)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2156048",
		"itemLabel": "château de Salgas",
		"geo": "Point(3.58417 44.2564)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2157437",
		"itemLabel": "château d'Héricourt",
		"geo": "Point(6.757769 47.577081)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2166293",
		"itemLabel": "château de Buffières",
		"geo": "Point(4.86972 46.4722)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2172429",
		"itemLabel": "château de Laroque",
		"geo": "Point(2.1889 44.9694)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2176659",
		"itemLabel": "château de Champchevrier",
		"geo": "Point(0.39 47.444167)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2176795",
		"itemLabel": "château de Bourdeilles",
		"geo": "Point(0.586666666 45.3225)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2180623",
		"itemLabel": "château de Savignac-le-Haut",
		"geo": "Point(3.10222 43.3933)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2182818",
		"itemLabel": "château de Gizeux",
		"geo": "Point(0.206111 47.390556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2184056",
		"itemLabel": "château Régis",
		"geo": "Point(5.50028 43.2897)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2186251",
		"itemLabel": "château de Florac",
		"geo": "Point(3.59375 44.32285)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2187991",
		"itemLabel": "château de la Reynarde",
		"geo": "Point(5.5056 43.2897)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2188774",
		"itemLabel": "château de Chémery",
		"geo": "Point(1.47995 47.3452)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2190858",
		"itemLabel": "château de Bazoches",
		"geo": "Point(3.795 47.3808)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2192076",
		"itemLabel": "château de Cropières",
		"geo": "Point(2.66056 44.9231)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2194736",
		"itemLabel": "château de Montmirail",
		"geo": "Point(3.5377 48.8693)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2197014",
		"itemLabel": "château de Craincourt",
		"geo": "Point(6.32117 48.8755)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2200119",
		"itemLabel": "château de Bosmelet",
		"geo": "Point(1.12777778 49.70111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2201517",
		"itemLabel": "château de Traslage",
		"geo": "Point(1.39556 45.6875)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2201602",
		"itemLabel": "château de Dampierre-sur-Boutonne",
		"geo": "Point(-0.415749 46.0677)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2202660",
		"itemLabel": "château d'Ablon",
		"geo": "Point(0.301242 49.3884)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2206135",
		"itemLabel": "château de Bonaguil",
		"geo": "Point(1.014444444 44.538333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2210274",
		"itemLabel": "château du Plessis",
		"geo": "Point(3.11333 46.5394)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2214680",
		"itemLabel": "château de Montaure",
		"geo": "Point(1.08694 49.2314)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2218826",
		"itemLabel": "château de la Rivière-Bourdet",
		"geo": "Point(0.945 49.4133)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2221273",
		"itemLabel": "château de Saissac",
		"geo": "Point(2.167972222 43.356944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2221500",
		"itemLabel": "château du Bouilh",
		"geo": "Point(-0.45583333 45.00916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2221609",
		"itemLabel": "château de Saint-Blancard",
		"geo": "Point(0.6475 43.345)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2226645",
		"itemLabel": "château de Dreistein",
		"geo": "Point(7.39083333 48.44)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2226745",
		"itemLabel": "château de Quierzy",
		"geo": "Point(3.14686 49.5759)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2229977",
		"itemLabel": "château de Buis",
		"geo": "Point(4.21495 47.1368)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2237070",
		"itemLabel": "château de Beaulieu",
		"geo": "Point(4.79167 46.2775)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240085",
		"itemLabel": "château d'Argy",
		"geo": "Point(1.43555556 46.93888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240167",
		"itemLabel": "château de Bailleul",
		"geo": "Point(0.45000278 49.67420556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240202",
		"itemLabel": "château de Baugé",
		"geo": "Point(-0.104138888 47.543277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240222",
		"itemLabel": "château de Beaumesnil",
		"geo": "Point(0.711388888 49.013888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240350",
		"itemLabel": "château de Bompré",
		"geo": "Point(3.254 46.23506)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240361",
		"itemLabel": "château de Boucard",
		"geo": "Point(2.68166667 47.35047222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240551",
		"itemLabel": "château de Cirey",
		"geo": "Point(4.93944444 48.32972222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2240557",
		"itemLabel": "château de Cognac",
		"geo": "Point(-0.33 45.698333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970924",
		"itemLabel": "château de Vaujours",
		"geo": "Point(0.34722222 47.52777778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970925",
		"itemLabel": "château de Vaure",
		"geo": "Point(-0.03636 44.7863)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970926",
		"itemLabel": "château de Vaussèche",
		"geo": "Point(4.61639 44.9058)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970930",
		"itemLabel": "château de Vaux",
		"geo": "Point(-0.514528 47.7849)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970932",
		"itemLabel": "château de Vauvenargues",
		"geo": "Point(5.603888888 43.553888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970934",
		"itemLabel": "château de Vaux-sous-Targe",
		"geo": "Point(4.81694 46.4389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970935",
		"itemLabel": "château de Vaux",
		"geo": "Point(4.26223 48.1248)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970938",
		"itemLabel": "château de Vendeuvre-sur-Barse",
		"geo": "Point(4.47237 48.2372)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970939",
		"itemLabel": "château de Veauce",
		"geo": "Point(3.05542 46.1638)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970943",
		"itemLabel": "château de Verdelles",
		"geo": "Point(-0.247222 47.9003)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970946",
		"itemLabel": "château de Vermoise",
		"geo": "Point(4.03866 48.3625)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970949",
		"itemLabel": "château de Verneuil-en-Bourbonnais",
		"geo": "Point(3.25088 46.346)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970950",
		"itemLabel": "château de Verneuil-sur-Indre",
		"geo": "Point(1.03976 47.0553)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970953",
		"itemLabel": "château de Vendeuvre",
		"geo": "Point(-0.078611111 48.986944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970959",
		"itemLabel": "château de Verseilles",
		"geo": "Point(3.53772 46.1542)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970960",
		"itemLabel": "château de Versainville",
		"geo": "Point(-0.18028 48.9139)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970961",
		"itemLabel": "château de Versols",
		"geo": "Point(2.9361 43.8929)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970967",
		"itemLabel": "château de Verteuil",
		"geo": "Point(0.2306 45.9828)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970968",
		"itemLabel": "château de Vic-sur-Aisne",
		"geo": "Point(3.11403 49.4057)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970971",
		"itemLabel": "château de Viels-Maisons",
		"geo": "Point(3.3975 48.8953)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970974",
		"itemLabel": "château de Vierzy",
		"geo": "Point(3.2837 49.2929)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970975",
		"itemLabel": "château de Viescamp",
		"geo": "Point(2.28041 44.9198)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970977",
		"itemLabel": "château de Vignoux",
		"geo": "Point(2.51591 46.3594)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970978",
		"itemLabel": "château de Vieillecour",
		"geo": "Point(1.01833333 45.58805556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970979",
		"itemLabel": "château de Vigny",
		"geo": "Point(1.92612 49.0767)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970980",
		"itemLabel": "château de Vigouroux",
		"geo": "Point(2.80417 44.9231)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970981",
		"itemLabel": "château de Vignory",
		"geo": "Point(5.10138889 48.27666667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970985",
		"itemLabel": "château de Villaines",
		"geo": "Point(0.01639 47.9272)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970986",
		"itemLabel": "château de Villar-en-Val",
		"geo": "Point(2.45858 43.0828)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970987",
		"itemLabel": "château de Villaret",
		"geo": "Point(3.67789 44.5242)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970989",
		"itemLabel": "château de Villars-en-Azois",
		"geo": "Point(4.74625 48.0674)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970990",
		"itemLabel": "château de Villarzel",
		"geo": "Point(2.20657 43.1402)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970992",
		"itemLabel": "château de Ville-Savoye",
		"geo": "Point(3.64037 49.2929)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970994",
		"itemLabel": "château de Villebois-Lavalette",
		"geo": "Point(0.28278 45.4842)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970995",
		"itemLabel": "château de Villeconin",
		"geo": "Point(2.12324 48.5137)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970996",
		"itemLabel": "château de Villefort",
		"geo": "Point(2.23 45.9067)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970998",
		"itemLabel": "château de Villemartin",
		"geo": "Point(2.19801 43.0828)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2970999",
		"itemLabel": "château de Villandraut",
		"geo": "Point(-0.372777777 44.459722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971000",
		"itemLabel": "château de Villebon",
		"geo": "Point(1.20704 48.3908)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971001",
		"itemLabel": "château de Villemereuil",
		"geo": "Point(4.08719 48.1996)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971002",
		"itemLabel": "château de Villemont",
		"geo": "Point(3.19722 46.0544)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971005",
		"itemLabel": "château de Villemonteix",
		"geo": "Point(2.14312 46.1079)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971006",
		"itemLabel": "château de Villemorien",
		"geo": "Point(4.29472 48.085)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971007",
		"itemLabel": "château de Villeneuve",
		"geo": "Point(-0.454913 47.2221)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971010",
		"itemLabel": "château de Villeneuve-Loubet",
		"geo": "Point(7.12424 43.6598)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971011",
		"itemLabel": "château de Villeneuve-Saint-Germain",
		"geo": "Point(3.35282 49.3811)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971015",
		"itemLabel": "château de Villers-Cotterêts",
		"geo": "Point(3.0922 49.256)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971016",
		"itemLabel": "château de Villers",
		"geo": "Point(4.9243 49.5961)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971017",
		"itemLabel": "château de Villers-Hélon",
		"geo": "Point(3.26056 49.2667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971018",
		"itemLabel": "château de Villers-Saint-Paul",
		"geo": "Point(2.4822 49.2847)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971020",
		"itemLabel": "château de Villette",
		"geo": "Point(4.89832 49.7102)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971022",
		"itemLabel": "château de Villevert",
		"geo": "Point(0.69139 46.0228)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971027",
		"itemLabel": "château de Villiers-Saint-Denis",
		"geo": "Point(3.26661 48.9952)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971034",
		"itemLabel": "château de Vins",
		"geo": "Point(6.14339 43.4326)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971037",
		"itemLabel": "château de Vinzelles",
		"geo": "Point(4.76139 46.2708)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971039",
		"itemLabel": "château de Viré",
		"geo": "Point(-0.29694 47.9778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971041",
		"itemLabel": "château de Visigneux",
		"geo": "Point(4.27 47.0906)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971042",
		"itemLabel": "château de Viviers",
		"geo": "Point(3.9184 47.8039)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971043",
		"itemLabel": "château de Vocance",
		"geo": "Point(4.55537 45.2033)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971044",
		"itemLabel": "château de Vogüé",
		"geo": "Point(4.41397 44.551)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971046",
		"itemLabel": "château de Vissec",
		"geo": "Point(3.46 43.9)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971047",
		"itemLabel": "château de Volonne",
		"geo": "Point(6.01394 44.1112)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971052",
		"itemLabel": "château de Vézins-de-Lévézou",
		"geo": "Point(2.95305556 44.27972222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971055",
		"itemLabel": "château de Waldeck",
		"geo": "Point(7.527 49.0178)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971058",
		"itemLabel": "château de Wasigny",
		"geo": "Point(4.35685 49.6357)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971059",
		"itemLabel": "château de Wangenbourg",
		"geo": "Point(7.31416667 48.62083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971061",
		"itemLabel": "château de Wasselonne",
		"geo": "Point(7.44583 48.6382)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971068",
		"itemLabel": "château de Woippy",
		"geo": "Point(6.14569 49.152)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971071",
		"itemLabel": "château de Wœrth",
		"geo": "Point(7.74719 48.9389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971073",
		"itemLabel": "château de Xaintrailles",
		"geo": "Point(0.2564 44.2075)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971082",
		"itemLabel": "château de l'Ambroise",
		"geo": "Point(-0.413362 47.3955)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971083",
		"itemLabel": "château de l'Argentaye",
		"geo": "Point(-2.22237 48.5415)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971086",
		"itemLabel": "château de l'Audardière",
		"geo": "Point(-1.7592 46.732)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971088",
		"itemLabel": "château de l'Augère",
		"geo": "Point(3.16433 46.622)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971090",
		"itemLabel": "château de l'Arthaudière",
		"geo": "Point(5.233055555 45.119166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971095",
		"itemLabel": "château de l'Engarran",
		"geo": "Point(3.80689 43.5978)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971101",
		"itemLabel": "château de l'Hermine (Vannes)",
		"geo": "Point(-2.7562 47.6562)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971110",
		"itemLabel": "château de l'Isle",
		"geo": "Point(1.9944 47.8883)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971111",
		"itemLabel": "château de l'Islette",
		"geo": "Point(0.434226 47.2675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971115",
		"itemLabel": "château de l'Ours",
		"geo": "Point(2.57328 46.2607)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971120",
		"itemLabel": "château de l'Étang",
		"geo": "Point(3.65787 49.8741)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971124",
		"itemLabel": "château de la Barben",
		"geo": "Point(5.20583 43.6278)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971126",
		"itemLabel": "château de la Barbée",
		"geo": "Point(-0.18167 47.6783)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971132",
		"itemLabel": "château de la Barthe",
		"geo": "Point(1.8019 43.3157)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971133",
		"itemLabel": "château de la Basse-Touligny",
		"geo": "Point(4.63862 49.6674)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971136",
		"itemLabel": "château de la Baume",
		"geo": "Point(3.19361 44.6494)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971139",
		"itemLabel": "château de la Beaume",
		"geo": "Point(3.04556 46.7537)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971140",
		"itemLabel": "château de la Barre",
		"geo": "Point(5.62277778 45.63222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971142",
		"itemLabel": "château de la Berthière",
		"geo": "Point(-0.426369 47.5154)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971145",
		"itemLabel": "château de la Bien-Boire",
		"geo": "Point(-0.01005 47.2306)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971148",
		"itemLabel": "château de la Besse (Milhac-d'Auberoche)",
		"geo": "Point(0.92166667 45.13194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971150",
		"itemLabel": "château de la Boissonnade",
		"geo": "Point(2.83306 44.7002)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971151",
		"itemLabel": "château de la Bonnetière",
		"geo": "Point(0.0942 46.8922)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971154",
		"itemLabel": "château de la Boube",
		"geo": "Point(3.56089 46.6258)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971155",
		"itemLabel": "château de la Bonnetie",
		"geo": "Point(0.87944444 45.24083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971158",
		"itemLabel": "château de la Bourbansais",
		"geo": "Point(-1.8969 48.4043)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971159",
		"itemLabel": "château de la Bourgonnière",
		"geo": "Point(-1.08919 47.3481)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971162",
		"itemLabel": "château de la Brosse-Raquin",
		"geo": "Point(2.85708 46.4319)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971166",
		"itemLabel": "château de la Brangelie",
		"geo": "Point(0.28416667 45.22138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971167",
		"itemLabel": "château de la Brunière",
		"geo": "Point(-1.39806 46.4605)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968366",
		"itemLabel": "château d'eau de la source d'Arcier",
		"geo": "Point(6.0292 47.2335)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968368",
		"itemLabel": "château d'Écharbot",
		"geo": "Point(-0.479504 47.4969)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968373",
		"itemLabel": "château d'Échuilly",
		"geo": "Point(-0.312756 47.1406)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968374",
		"itemLabel": "château d'Éclance",
		"geo": "Point(4.6334 48.3079)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968377",
		"itemLabel": "château d'Écoyeux",
		"geo": "Point(-0.508889 45.8231)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968378",
		"itemLabel": "château d'Échéry",
		"geo": "Point(7.19638889 48.26833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968379",
		"itemLabel": "château d'Épanvilliers",
		"geo": "Point(0.19 46.2564)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968381",
		"itemLabel": "château d'Épierre",
		"geo": "Point(5.47031 46.0607)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968384",
		"itemLabel": "château d'Épinats",
		"geo": "Point(-0.206745 47.1972)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968385",
		"itemLabel": "château d'Éguilly",
		"geo": "Point(4.50416667 47.30333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968386",
		"itemLabel": "château d'Époisses",
		"geo": "Point(4.1711 47.5074)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968388",
		"itemLabel": "château d'Épinal",
		"geo": "Point(6.4556 48.1753)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968389",
		"itemLabel": "château d'Étalans",
		"geo": "Point(6.27959 47.1447)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968393",
		"itemLabel": "château d'Ô",
		"geo": "Point(3.83903 43.6332)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968394",
		"itemLabel": "château d'Étobon",
		"geo": "Point(6.675 47.64944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968397",
		"itemLabel": "château de Bagnac",
		"geo": "Point(0.970143 46.1521)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968403",
		"itemLabel": "château de Bagnols",
		"geo": "Point(4.60861 45.9167)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968404",
		"itemLabel": "château de Bailleul-sur-Thérain",
		"geo": "Point(2.21302 49.3849)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968405",
		"itemLabel": "château de Bagatelle",
		"geo": "Point(2.247222222 48.871666666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968407",
		"itemLabel": "château de Bainville-aux-Miroirs",
		"geo": "Point(6.2776 48.4381)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968408",
		"itemLabel": "château de Balaine",
		"geo": "Point(3.24633 46.697)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968409",
		"itemLabel": "château de Balanzac",
		"geo": "Point(-0.8375 45.7397)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968410",
		"itemLabel": "château de Balazuc",
		"geo": "Point(4.37271 44.509)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968411",
		"itemLabel": "château de Bagnolet",
		"geo": "Point(2.40625 48.861944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968412",
		"itemLabel": "château de Balincourt",
		"geo": "Point(2.11149 49.15771)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968413",
		"itemLabel": "château de Ballon",
		"geo": "Point(0.233056 48.1789)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968416",
		"itemLabel": "château de Balsac",
		"geo": "Point(2.4434 44.4023)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968417",
		"itemLabel": "château de Balzac",
		"geo": "Point(0.10917 45.7078)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968419",
		"itemLabel": "château de Banassat",
		"geo": "Point(3.06193 46.2481)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968420",
		"itemLabel": "château de Balleure",
		"geo": "Point(4.80083333 46.57833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968425",
		"itemLabel": "château de Baraigne",
		"geo": "Point(1.82083 43.33)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968429",
		"itemLabel": "château de Bar-sur-Seine",
		"geo": "Point(4.3725 48.11333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968431",
		"itemLabel": "château de Barbentane",
		"geo": "Point(4.7475 43.9006)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968432",
		"itemLabel": "château de Barberey-Saint-Sulpice",
		"geo": "Point(4.03763 48.3375)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968433",
		"itemLabel": "château de Béduer",
		"geo": "Point(1.9525 44.58)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968436",
		"itemLabel": "château de Barbezières",
		"geo": "Point(-0.1111 45.915)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968437",
		"itemLabel": "château de Barbirey",
		"geo": "Point(4.75516 47.2523)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968440",
		"itemLabel": "château de Barjac",
		"geo": "Point(4.34619 44.3079)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968448",
		"itemLabel": "château de Bartherans",
		"geo": "Point(5.92769 47.0412)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968449",
		"itemLabel": "château de Baulx",
		"geo": "Point(3.6183 43.8294)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968450",
		"itemLabel": "château de Baugé",
		"geo": "Point(-0.164073 47.052)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968451",
		"itemLabel": "château de Baville",
		"geo": "Point(2.12677 48.5668)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968452",
		"itemLabel": "château de Bazeilles",
		"geo": "Point(4.98139 49.6736)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968454",
		"itemLabel": "château de Bayers",
		"geo": "Point(0.22917 45.9203)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968455",
		"itemLabel": "château de Bazoges-en-Pareds",
		"geo": "Point(-0.915062 46.6564)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968456",
		"itemLabel": "château de Bazoches-sur-Vesles",
		"geo": "Point(3.61737 49.3063)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968460",
		"itemLabel": "château de Beaufief",
		"geo": "Point(-0.55056 45.925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968464",
		"itemLabel": "château de Beaufort-en-Vallée",
		"geo": "Point(-0.21933 47.4391)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968469",
		"itemLabel": "château de Beaufort",
		"geo": "Point(6.56167 45.7275)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968472",
		"itemLabel": "château de Beaufort",
		"geo": "Point(3.923888888 44.888055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968473",
		"itemLabel": "château de Beaulieu",
		"geo": "Point(-0.04673 47.248)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968474",
		"itemLabel": "château de Beaulon",
		"geo": "Point(3.67047 46.6002)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968477",
		"itemLabel": "château de Beaumanoir",
		"geo": "Point(-1.97972 48.3833)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968478",
		"itemLabel": "château de Beaulon",
		"geo": "Point(-0.70472 45.4342)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968479",
		"itemLabel": "château de Beaumarchais",
		"geo": "Point(-1.85811 46.6528)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968480",
		"itemLabel": "château de Beaume",
		"geo": "Point(4.42444 45.105)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968482",
		"itemLabel": "château de Beaumefort",
		"geo": "Point(4.29445 44.4256)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968484",
		"itemLabel": "château de Beaumont-sur-Vingeanne",
		"geo": "Point(5.36514 47.4611)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968485",
		"itemLabel": "château de Beaumont",
		"geo": "Point(4.85902 46.1578)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968486",
		"itemLabel": "château de Beaumont-le-Richard",
		"geo": "Point(-0.96667 49.3703)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968489",
		"itemLabel": "château de Beaumont-sur-Oise",
		"geo": "Point(2.28638889 49.14388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968490",
		"itemLabel": "château de Beauregard",
		"geo": "Point(3.07247 46.737)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968493",
		"itemLabel": "château de Beauregard",
		"geo": "Point(2.16366 48.6614)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968495",
		"itemLabel": "château de Beauregard (Haute-Savoie)",
		"geo": "Point(6.45576 46.1401)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968497",
		"itemLabel": "château de Beauregard",
		"geo": "Point(5.67455 45.1714)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968501",
		"itemLabel": "château de Beaurevoir",
		"geo": "Point(3.30186 49.9927)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968505",
		"itemLabel": "château de Beauverger",
		"geo": "Point(3.22511 46.1366)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968506",
		"itemLabel": "château de Beauséjour",
		"geo": "Point(0.475 45.25388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968507",
		"itemLabel": "château de Beauville",
		"geo": "Point(0.8784 44.2791)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968508",
		"itemLabel": "château de Beauvoir",
		"geo": "Point(2.94036 46.1825)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968509",
		"itemLabel": "château de Beauvais",
		"geo": "Point(0.58972222 45.51166667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968514",
		"itemLabel": "château de Beire-le-Châtel",
		"geo": "Point(5.2022 47.413)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968515",
		"itemLabel": "château de Bel Abord",
		"geo": "Point(2.31313 48.7064)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968517",
		"itemLabel": "château de Bel Air de Sigonce",
		"geo": "Point(5.83567 44.0004)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968518",
		"itemLabel": "château de Belflou",
		"geo": "Point(1.7862 43.3186)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968521",
		"itemLabel": "château de Bellenaves",
		"geo": "Point(3.07706 46.1997)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968526",
		"itemLabel": "château de Belombre",
		"geo": "Point(3.60676 47.7274)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968528",
		"itemLabel": "château de Bellegarde",
		"geo": "Point(2.44181 47.987)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968530",
		"itemLabel": "château de Belvès",
		"geo": "Point(1.0057 44.7762)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968535",
		"itemLabel": "château de Berbiguières",
		"geo": "Point(1.04125 44.8342)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968537",
		"itemLabel": "château de Bernicourt",
		"geo": "Point(3.10341 50.4228)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968539",
		"itemLabel": "château de Bernoville",
		"geo": "Point(3.50755 49.9309)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968541",
		"itemLabel": "château de Berrie",
		"geo": "Point(-0.071111 47.0672)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968542",
		"itemLabel": "château de Berzy-le-Sec",
		"geo": "Point(3.31169 49.3333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968543",
		"itemLabel": "château de Berzème",
		"geo": "Point(4.56661 44.6519)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968545",
		"itemLabel": "château de Betz",
		"geo": "Point(0.916275 46.9893)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968547",
		"itemLabel": "château de Besanceuil",
		"geo": "Point(4.60611 46.5464)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968548",
		"itemLabel": "château de Beuzon",
		"geo": "Point(-0.513375 47.5061)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968551",
		"itemLabel": "château de Bien-Assis",
		"geo": "Point(2.57583 46.3436)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968552",
		"itemLabel": "château de Bienassis",
		"geo": "Point(-2.487 48.5882)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968557",
		"itemLabel": "château de Bisseret",
		"geo": "Point(2.61556 46.3151)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968561",
		"itemLabel": "château de Bidache",
		"geo": "Point(-1.13833 43.4875)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968562",
		"itemLabel": "château de Blanquefort-sur-Briolance",
		"geo": "Point(0.969722 44.5994)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968564",
		"itemLabel": "château de Blanzat",
		"geo": "Point(3.20731 46.2572)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968565",
		"itemLabel": "château de Bity",
		"geo": "Point(1.92111 45.4169)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968566",
		"itemLabel": "château de Blanquefort",
		"geo": "Point(-0.63 44.90111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968567",
		"itemLabel": "château de Blosset",
		"geo": "Point(2.17528 47.2056)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968570",
		"itemLabel": "château de Bléneau",
		"geo": "Point(2.95076 47.6979)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968575",
		"itemLabel": "château de Blâmont",
		"geo": "Point(6.845277777 48.591388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968577",
		"itemLabel": "château de Bois-Sire-Amé",
		"geo": "Point(2.47972 46.9319)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971168",
		"itemLabel": "château de la Bréchinie",
		"geo": "Point(0.4162 45.5748)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971170",
		"itemLabel": "château de la Bâtie",
		"geo": "Point(4.82536 46.0954)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971171",
		"itemLabel": "château de la Bâtie",
		"geo": "Point(4.87642 45.5308)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971172",
		"itemLabel": "château de la Buzine",
		"geo": "Point(5.5025 43.2953)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971173",
		"itemLabel": "château de la Bénaudière",
		"geo": "Point(-0.783031 47.4116)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971174",
		"itemLabel": "château de la Calade",
		"geo": "Point(5.38972 43.5728)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971177",
		"itemLabel": "château de la Caunette",
		"geo": "Point(2.38278 43.32)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971178",
		"itemLabel": "château de la Chaise",
		"geo": "Point(4.6611 48.3628)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971179",
		"itemLabel": "château de la Bâtie",
		"geo": "Point(5.98444444 45.57944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971182",
		"itemLabel": "château de la Chassagne",
		"geo": "Point(4.12194 46.5161)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971184",
		"itemLabel": "château de la Chasse",
		"geo": "Point(2.29268 49.0301)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971185",
		"itemLabel": "château de la Chaussade",
		"geo": "Point(3.20598 47.0936)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971187",
		"itemLabel": "château de la Chalupie",
		"geo": "Point(0.84222222 45.16055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971188",
		"itemLabel": "château de la Chaussière",
		"geo": "Point(2.88825 46.5137)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971191",
		"itemLabel": "château de la Chetardière",
		"geo": "Point(-0.889599 47.6756)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971195",
		"itemLabel": "château de la Clayette",
		"geo": "Point(4.30583333 46.29333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971200",
		"itemLabel": "château de la Condemine",
		"geo": "Point(2.96986 46.4752)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971201",
		"itemLabel": "château de la Cosse",
		"geo": "Point(1.12787 45.8741)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971202",
		"itemLabel": "château de la Cour-au-Berruyer",
		"geo": "Point(0.41 47.2569)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971203",
		"itemLabel": "château de la Cour-en-Chapeau",
		"geo": "Point(3.51544 46.4881)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971204",
		"itemLabel": "château de la Cour de Cellières",
		"geo": "Point(-0.500973 47.6427)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971206",
		"itemLabel": "château de la Courbe de Brée",
		"geo": "Point(-0.4969 48.1445)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971208",
		"itemLabel": "château de la Croix",
		"geo": "Point(6.55201 46.0604)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971209",
		"itemLabel": "château de la Croizette",
		"geo": "Point(3.19286 46.212)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971210",
		"itemLabel": "château de la Crête",
		"geo": "Point(2.53897 46.4578)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971211",
		"itemLabel": "château de la Côte-au-Chapt",
		"geo": "Point(0.9528 46.2681)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971212",
		"itemLabel": "château de la Durbelière",
		"geo": "Point(-0.687222 46.95)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971213",
		"itemLabel": "château de la Croë",
		"geo": "Point(7.13413 43.54605)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971214",
		"itemLabel": "château de la Farinière",
		"geo": "Point(0.474722 47.3522)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971216",
		"itemLabel": "château de la Faucille",
		"geo": "Point(-0.915996 47.743)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971220",
		"itemLabel": "château de la Favorite",
		"geo": "Point(6.50391 48.5921)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971221",
		"itemLabel": "château de la Faye",
		"geo": "Point(1.12612 45.1051)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971222",
		"itemLabel": "château de la Faye",
		"geo": "Point(0.01806 45.4114)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971223",
		"itemLabel": "château de la Faye",
		"geo": "Point(-0.433889 45.3764)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971228",
		"itemLabel": "château de la Ferté",
		"geo": "Point(2.04019 47.0652)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971231",
		"itemLabel": "château de la Finou",
		"geo": "Point(0.741056 44.8737)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971232",
		"itemLabel": "château de la Ferté-Vidame",
		"geo": "Point(0.899591 48.6082)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971234",
		"itemLabel": "château de la Forge",
		"geo": "Point(5.08418 48.6859)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971236",
		"itemLabel": "château de la Forêt",
		"geo": "Point(2.95314 46.5394)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971237",
		"itemLabel": "château de la Forêt de Viry",
		"geo": "Point(3.80878 46.4093)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971238",
		"itemLabel": "château de la Fleunie",
		"geo": "Point(1.2225 45.09277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971239",
		"itemLabel": "château de la Fresnaye",
		"geo": "Point(-0.194722 48.8975)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971240",
		"itemLabel": "château de la Freudière",
		"geo": "Point(-1.57258 47.0848)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971243",
		"itemLabel": "château de la Gascherie",
		"geo": "Point(-1.53784 47.297)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971244",
		"itemLabel": "château de la Gaubertie",
		"geo": "Point(0.63166667 44.95555556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971245",
		"itemLabel": "château de la Gane",
		"geo": "Point(2.37389 45.4947)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971248",
		"itemLabel": "château de la Germonière",
		"geo": "Point(-1.35876 49.6211)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971249",
		"itemLabel": "château de la Girottière",
		"geo": "Point(-0.094253 47.3822)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971251",
		"itemLabel": "château de la Grandière",
		"geo": "Point(-0.665 47.6142)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971252",
		"itemLabel": "château de la Grange",
		"geo": "Point(3.41101 44.6028)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971253",
		"itemLabel": "château de la Grange",
		"geo": "Point(2.49522 48.729)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971255",
		"itemLabel": "château de la Grande Filolie",
		"geo": "Point(1.21055556 45.04444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971256",
		"itemLabel": "château de la Grifferie",
		"geo": "Point(0.15528 47.6778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971257",
		"itemLabel": "château de la Grillière",
		"geo": "Point(3.30172 46.3916)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971258",
		"itemLabel": "château de la Grézille",
		"geo": "Point(-0.342778 47.2642)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971260",
		"itemLabel": "château de la Guibourgère",
		"geo": "Point(-1.29797 47.486)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971261",
		"itemLabel": "château de la Guittière",
		"geo": "Point(0.834371 46.6587)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971263",
		"itemLabel": "château de la Guyonnière",
		"geo": "Point(-0.243056 46.5828)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971265",
		"itemLabel": "château de la Haute-Guerche",
		"geo": "Point(-0.666111 47.3286)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971270",
		"itemLabel": "château de la Guignardière",
		"geo": "Point(-1.51 46.474)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971272",
		"itemLabel": "château de la Jaille",
		"geo": "Point(0.51597 47.7444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971278",
		"itemLabel": "château de la Juive",
		"geo": "Point(6.06222222 47.24888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971279",
		"itemLabel": "château de la Lorie",
		"geo": "Point(-0.848629 47.6785)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971281",
		"itemLabel": "château de la Léotardie",
		"geo": "Point(0.06778 45.4231)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971288",
		"itemLabel": "château de la Martinière",
		"geo": "Point(2.21142 48.7563)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971289",
		"itemLabel": "château de la Mauvoisinière",
		"geo": "Point(-1.09847 47.3315)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971292",
		"itemLabel": "château de la Madeleine",
		"geo": "Point(2.04194444 48.71)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971294",
		"itemLabel": "château de la Mesnerie",
		"geo": "Point(-1.53533 47.2727)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971295",
		"itemLabel": "château de la Meyfrenie",
		"geo": "Point(0.369051 45.3448)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971297",
		"itemLabel": "château de la Moglais",
		"geo": "Point(-2.48476 48.4699)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971301",
		"itemLabel": "château de la Morinerie",
		"geo": "Point(-0.683056 45.7867)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971302",
		"itemLabel": "château de la Mogère",
		"geo": "Point(3.925961111 43.600527777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971303",
		"itemLabel": "château de la Morinière",
		"geo": "Point(-0.509727 47.366)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971304",
		"itemLabel": "château de la Morlière",
		"geo": "Point(-1.59616 47.2553)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971305",
		"itemLabel": "château de la Mormaire",
		"geo": "Point(1.75545 48.766)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971306",
		"itemLabel": "château de la Mosson",
		"geo": "Point(3.81912 43.6137)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971308",
		"itemLabel": "château de la Motte-Broons"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971310",
		"itemLabel": "château de la Mothe",
		"geo": "Point(0.2 45.23083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971311",
		"itemLabel": "château de la Motte-Grollier",
		"geo": "Point(-0.203784 47.7188)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971313",
		"itemLabel": "château de la Motte-Sonzay",
		"geo": "Point(0.463 47.512)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971316",
		"itemLabel": "château de la Motte",
		"geo": "Point(1.894722222 47.613888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971317",
		"itemLabel": "château de la Motte",
		"geo": "Point(2.89931 48.2349)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971318",
		"itemLabel": "château de la Motte",
		"geo": "Point(-1.34882 48.4079)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971321",
		"itemLabel": "château de la Motte",
		"geo": "Point(4.91417 46.7511)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971326",
		"itemLabel": "château de la Noë",
		"geo": "Point(-0.646322 49.3263)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971327",
		"itemLabel": "château de la Noue",
		"geo": "Point(-0.596008 47.3797)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971328",
		"itemLabel": "château de la Noë Bel-Air",
		"geo": "Point(-1.2879 47.1783)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971329",
		"itemLabel": "château de la Muyre",
		"geo": "Point(5.57194444 46.75388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971331",
		"itemLabel": "château de la Palud-sur-Verdon",
		"geo": "Point(6.34117 43.7797)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971333",
		"itemLabel": "château de la Perraudière",
		"geo": "Point(-0.257471 47.521)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971334",
		"itemLabel": "château de la Napoule",
		"geo": "Point(6.943055555 43.523333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971336",
		"itemLabel": "château de la Petite Malmaison",
		"geo": "Point(2.160573 48.869802)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971337",
		"itemLabel": "château de la Pigeonnière",
		"geo": "Point(1.30249 47.5329)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971339",
		"itemLabel": "château de la Petite Filolie",
		"geo": "Point(1.21388889 45.095)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971340",
		"itemLabel": "château de la Plesnoye",
		"geo": "Point(3.8106 49.9242)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971344",
		"itemLabel": "château de la Porte de Mars",
		"geo": "Point(4.029944 49.260611)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971347",
		"itemLabel": "château de la Prune-au-Pot",
		"geo": "Point(1.55673 46.5174)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971348",
		"itemLabel": "château de la Punta",
		"geo": "Point(8.7083 41.9567)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971349",
		"itemLabel": "château de la Pèze",
		"geo": "Point(1.96516 44.3591)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971350",
		"itemLabel": "château de la Rairie",
		"geo": "Point(-1.57658 47.1349)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q4326703",
		"itemLabel": "Q4326703",
		"geo": "Point(1.4056 47.0845)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5049946",
		"itemLabel": "Q5049946",
		"geo": "Point(0.6525 44.20888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118671",
		"itemLabel": "Q5118671",
		"geo": "Point(4.78833333 47.32722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118685",
		"itemLabel": "Q5118685",
		"geo": "Point(-0.37388889 44.72083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118693",
		"itemLabel": "château de Moncade",
		"geo": "Point(-0.769974 43.492)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118707",
		"itemLabel": "château Sainte-Marie",
		"geo": "Point(1.23944444 43.3575)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118714",
		"itemLabel": "Q5118714"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118715",
		"itemLabel": "château d'Aiguèze",
		"geo": "Point(4.55666667 44.30305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118716",
		"itemLabel": "château d'Altkirch",
		"geo": "Point(7.23916667 47.62472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118720",
		"itemLabel": "Q5118720",
		"geo": "Point(2.72446 49.30989)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118721",
		"itemLabel": "Q5118721",
		"geo": "Point(3.9238 44.8661)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118722",
		"itemLabel": "château d'Aspach-le-Haut"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118724",
		"itemLabel": "château d'Aurignac",
		"geo": "Point(0.88 43.21972222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118729",
		"itemLabel": "château d'Entrechaux",
		"geo": "Point(5.13804 44.21967)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118730",
		"itemLabel": "château d'Homps",
		"geo": "Point(0.85611111 43.81083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118732",
		"itemLabel": "château d'Opme",
		"geo": "Point(3.09 45.7074)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118733",
		"itemLabel": "château d'Orcher",
		"geo": "Point(0.24638889 49.49694444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118734",
		"itemLabel": "Q5118734"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118736",
		"itemLabel": "château de Beaucaire",
		"geo": "Point(4.645 43.81)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118737",
		"itemLabel": "château de Beaumont-le-Vieux",
		"geo": "Point(5.18042 44.1804)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118738",
		"itemLabel": "Q5118738"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118740",
		"itemLabel": "château de Belpuig",
		"geo": "Point(2.62138889 42.56222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118741",
		"itemLabel": "château de Berthier",
		"geo": "Point(1.39611111 43.51138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118743",
		"itemLabel": "Q5118743",
		"geo": "Point(0.18694444 48.20055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118744",
		"itemLabel": "château de Boussan",
		"geo": "Point(0.89027778 43.24027778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118746",
		"itemLabel": "château de Bouvées",
		"geo": "Point(0.89166667 43.7475)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118747",
		"itemLabel": "château de Brax",
		"geo": "Point(1.24111111 43.61722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118748",
		"itemLabel": "château de Bucheneck",
		"geo": "Point(7.22972222 47.88611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118749",
		"itemLabel": "château de Cabrerets",
		"geo": "Point(1.654 44.5042)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118750",
		"itemLabel": "château de Calamane",
		"geo": "Point(1.39399 44.5231)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118751",
		"itemLabel": "château de Calmont",
		"geo": "Point(1.6325 43.28666667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118752",
		"itemLabel": "château de Cambiac",
		"geo": "Point(1.79083333 43.48944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118753",
		"itemLabel": "château de Castelnau-Montratier",
		"geo": "Point(1.35388 44.2672)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118754",
		"itemLabel": "Q5118754"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118755",
		"itemLabel": "château de Chabrillan",
		"geo": "Point(4.941584 44.724197)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118757",
		"itemLabel": "château de Chandioux",
		"geo": "Point(3.804417 47.046944)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118758",
		"itemLabel": "château de Charry",
		"geo": "Point(1.21027778 44.33972222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118759",
		"itemLabel": "château de Cinq-Mars",
		"geo": "Point(0.4625 47.34833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118760",
		"itemLabel": "château de Clermont",
		"geo": "Point(1.39549 44.6768)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118761",
		"itemLabel": "château de Clermont",
		"geo": "Point(5.53622 45.4174)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118762",
		"itemLabel": "château de Condat",
		"geo": "Point(1.653 44.4822)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118763",
		"itemLabel": "château de Couanac",
		"geo": "Point(1.700354 44.376076)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118766",
		"itemLabel": "château de Cénevières",
		"geo": "Point(1.75368 44.4628)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118767",
		"itemLabel": "château de Diant",
		"geo": "Point(2.995 48.27916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118770",
		"itemLabel": "château de Flamarens",
		"geo": "Point(0.79194444 44.01666667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118772",
		"itemLabel": "château de Fourquevaux",
		"geo": "Point(1.61944444 43.50527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118773",
		"itemLabel": "château de Frôlois",
		"geo": "Point(4.63166667 47.52777778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118774",
		"itemLabel": "château de Galié",
		"geo": "Point(0.63555556 42.98694444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118775",
		"itemLabel": "château de Ganges",
		"geo": "Point(3.70916667 43.935)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118776",
		"itemLabel": "Q5118776",
		"geo": "Point(3.33916667 44.51388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118777",
		"itemLabel": "château de Grâne",
		"geo": "Point(4.9225 44.73222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118778",
		"itemLabel": "château de Grugnac",
		"geo": "Point(2.0249 44.8852)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118779",
		"itemLabel": "château de Grégy",
		"geo": "Point(2.61861111 48.66694444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118780",
		"itemLabel": "château de Herrebouc",
		"geo": "Point(0.38277778 43.74055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118781",
		"itemLabel": "château de Hohenack",
		"geo": "Point(7.18416667 48.09416667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118782",
		"itemLabel": "château de Jean",
		"geo": "Point(1.50138889 43.74305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118783",
		"itemLabel": "château de Kolbsheim",
		"geo": "Point(7.58388889 48.56055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118784",
		"itemLabel": "château de La Coste",
		"geo": "Point(1.157738 44.476911)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118788",
		"itemLabel": "château de Labastide",
		"geo": "Point(1.78369 44.3441)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118789",
		"itemLabel": "château de Labastide-Paumès",
		"geo": "Point(0.94444444 43.33472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118790",
		"itemLabel": "château de Lacapelle-Marival",
		"geo": "Point(1.926013888 44.727672222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118791",
		"itemLabel": "château de Lacassagne",
		"geo": "Point(0.65277778 43.97388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118792",
		"itemLabel": "château de Lacoste",
		"geo": "Point(1.26348 44.68135)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118793",
		"itemLabel": "château de Larroque",
		"geo": "Point(0.60944444 43.19305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118794",
		"itemLabel": "château de Larnagol",
		"geo": "Point(1.778039 44.475862)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118795",
		"itemLabel": "château de Larressingle",
		"geo": "Point(0.31111111 43.94388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118796",
		"itemLabel": "château de Lasserre",
		"geo": "Point(0.40888889 43.93277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118797",
		"itemLabel": "château de Lastours",
		"geo": "Point(1.136806 44.354055)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118800",
		"itemLabel": "château de Lucéram",
		"geo": "Point(7.36188 43.8844)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118801",
		"itemLabel": "château de Lutzelbourg",
		"geo": "Point(7.40805556 48.46138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118802",
		"itemLabel": "château de Luzech",
		"geo": "Point(1.28777778 44.47916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118803",
		"itemLabel": "château de Masclat",
		"geo": "Point(1.99777778 44.68083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118804",
		"itemLabel": "château de Mayrac",
		"geo": "Point(1.5587 44.8993)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118808",
		"itemLabel": "château de Mirabat",
		"geo": "Point(1.2119 42.8448)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118809",
		"itemLabel": "château de Montaiguillon",
		"geo": "Point(3.5 48.63194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118810",
		"itemLabel": "Q5118810",
		"geo": "Point(2.4429 49.2563)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118811",
		"itemLabel": "château de Montespan",
		"geo": "Point(0.85055556 43.08722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118812",
		"itemLabel": "château de Montoire",
		"geo": "Point(0.857154 47.749983)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118814",
		"itemLabel": "château de Mérens",
		"geo": "Point(0.53916667 43.75277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118816",
		"itemLabel": "château de Nadaillac-de-Rouge",
		"geo": "Point(1.42972222 44.85)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118817",
		"itemLabel": "château de Pestillac",
		"geo": "Point(1.067624 44.546051)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118818",
		"itemLabel": "château de Padiès",
		"geo": "Point(2.04527778 43.53555556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118819",
		"itemLabel": "Q5118819",
		"geo": "Point(2.83777778 46.47472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118822",
		"itemLabel": "château médiéval de Pontevès",
		"geo": "Point(6.03138889 43.55416667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118824",
		"itemLabel": "château de Puy-Launay",
		"geo": "Point(2.11527778 44.66638889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118825",
		"itemLabel": "Q5118825",
		"geo": "Point(0.42472222 44.78888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118826",
		"itemLabel": "Q5118826",
		"geo": "Point(3.4381 43.4353)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118827",
		"itemLabel": "Q5118827",
		"geo": "Point(-0.02916667 47.00055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118828",
		"itemLabel": "Q5118828"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118829",
		"itemLabel": "château de Rochetaillée",
		"geo": "Point(4.4461 45.4101)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118830",
		"itemLabel": "château de Roquessels",
		"geo": "Point(3.22333333 43.5525)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118831",
		"itemLabel": "château de Rousson",
		"geo": "Point(4.13666667 44.185)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118832",
		"itemLabel": "château de Rudelle",
		"geo": "Point(1.31055556 43.45194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118833",
		"itemLabel": "château de Ruthie",
		"geo": "Point(-0.93410833 43.14977778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118834",
		"itemLabel": "château de Saignes",
		"geo": "Point(1.819 44.7846)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118835",
		"itemLabel": "château de Saint-Chaptes",
		"geo": "Point(4.27944444 43.97027778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118837",
		"itemLabel": "château de Saint-Félix-Lauragais",
		"geo": "Point(1.88972222 43.44888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118839",
		"itemLabel": "château de Saint-Jory",
		"geo": "Point(1.37083333 43.74361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118840",
		"itemLabel": "château de Saint-Ilpize",
		"geo": "Point(3.38833333 45.19444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118843",
		"itemLabel": "château de Saint-Maurice",
		"geo": "Point(3.51805556 43.84722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971351",
		"itemLabel": "château de la Reine Blanche",
		"geo": "Point(3.28784 48.5623)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971356",
		"itemLabel": "château de la Rivière (Manche)",
		"geo": "Point(-1.11544 49.2449)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971358",
		"itemLabel": "château de la Renaudie",
		"geo": "Point(0.72583333 45.44722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971359",
		"itemLabel": "château de la Rivoire",
		"geo": "Point(4.56215 45.2248)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971362",
		"itemLabel": "château de la Roche-Mailly",
		"geo": "Point(0.17556 47.7889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971363",
		"itemLabel": "château de la Roche-Jacquelin",
		"geo": "Point(-0.351048 47.671)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971364",
		"itemLabel": "château de la Roche-Othon",
		"geo": "Point(2.6725 46.5309)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971365",
		"itemLabel": "château de la Roche-Pichemer",
		"geo": "Point(-0.5361 48.1664)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971366",
		"itemLabel": "château de la Roche",
		"geo": "Point(2.90961 46.3692)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971367",
		"itemLabel": "château de la Roche",
		"geo": "Point(4.498 44.609)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971368",
		"itemLabel": "château de la Roche-Jagu",
		"geo": "Point(-3.1513 48.7332)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971369",
		"itemLabel": "château de la Roche Faton",
		"geo": "Point(-0.13361 46.7158)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971371",
		"itemLabel": "château de la Roche du Roi",
		"geo": "Point(5.91222 45.6806)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971372",
		"itemLabel": "château de la Roche",
		"geo": "Point(7.21777778 48.39611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971373",
		"itemLabel": "château de la Rochebeaucourt",
		"geo": "Point(0.37583 45.4869)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971374",
		"itemLabel": "château de la Rochefuret",
		"geo": "Point(0.629444 47.3494)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971375",
		"itemLabel": "château de la Rochefoucauld",
		"geo": "Point(2.4617 49.3274)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971377",
		"itemLabel": "château de la Rochette",
		"geo": "Point(6.42673 46.291)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971380",
		"itemLabel": "château de la Romanerie",
		"geo": "Point(-0.507592 47.4838)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971384",
		"itemLabel": "château de la Rongère",
		"geo": "Point(-0.7168 47.9084)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971384",
		"itemLabel": "château de la Rongère",
		"geo": "Point(-0.716767 47.9088)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971385",
		"itemLabel": "château de la Roque",
		"geo": "Point(2.94111111 43.80333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971386",
		"itemLabel": "château de la Roquette",
		"geo": "Point(3.818888888 43.793055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971387",
		"itemLabel": "château de la Rousselière",
		"geo": "Point(-0.527848 47.5903)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971388",
		"itemLabel": "château de la Rue",
		"geo": "Point(0.77825 44.8549)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971390",
		"itemLabel": "château de la Salle",
		"geo": "Point(4.84205 46.4053)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971391",
		"itemLabel": "château de la Salle",
		"geo": "Point(2.87672 46.5072)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971392",
		"itemLabel": "château de la Sayette",
		"geo": "Point(0.011389 46.5972)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971394",
		"itemLabel": "château de la Serraz",
		"geo": "Point(5.49007 45.8014)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971397",
		"itemLabel": "château de la Servairie",
		"geo": "Point(2.51325 44.5184)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971404",
		"itemLabel": "château de la Sorinière",
		"geo": "Point(-0.698962 47.2206)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971405",
		"itemLabel": "château de la Souche",
		"geo": "Point(2.8255 46.3425)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971406",
		"itemLabel": "château de la Sône",
		"geo": "Point(5.28372 45.1133)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971408",
		"itemLabel": "château de la Thibaudière",
		"geo": "Point(-0.637486 47.5426)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971412",
		"itemLabel": "château de la Touche-Savary",
		"geo": "Point(-0.828824 47.4072)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971413",
		"itemLabel": "château de la Tour",
		"geo": "Point(5.3742 46.076)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971424",
		"itemLabel": "château de la Tranchade",
		"geo": "Point(0.24056 45.6189)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971426",
		"itemLabel": "château de la Trolanderie",
		"geo": "Point(4.81917 45.8675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971432",
		"itemLabel": "château de la Trave",
		"geo": "Point(-0.34194444 44.40972222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971435",
		"itemLabel": "château de la Valade",
		"geo": "Point(0.57194444 45.29138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971439",
		"itemLabel": "château de la Vialette",
		"geo": "Point(3.08046014 43.93379864)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971440",
		"itemLabel": "château de la Verrerie",
		"geo": "Point(4.42333 46.8053)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971443",
		"itemLabel": "château de la Ville-au-Fourrier",
		"geo": "Point(0.080434 47.4042)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971445",
		"itemLabel": "château de la Villejégu",
		"geo": "Point(-1.29943 47.386)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971446",
		"itemLabel": "château de la Viveyre",
		"geo": "Point(3.18578 46.4971)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971448",
		"itemLabel": "château de la Voulte-sur-Rhône",
		"geo": "Point(4.78 44.8003)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971450",
		"itemLabel": "château de la Vrillière",
		"geo": "Point(-1.34993 47.2825)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971453",
		"itemLabel": "château des Aix",
		"geo": "Point(3.19039 46.3774)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971454",
		"itemLabel": "château des Aubiers",
		"geo": "Point(-2.6667 48.4989)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971457",
		"itemLabel": "château des Barres",
		"geo": "Point(3.2844 47.509)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971458",
		"itemLabel": "château des Bordeaux",
		"geo": "Point(-0.05444 48.025)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971463",
		"itemLabel": "château des Bourines",
		"geo": "Point(2.80944 44.4186)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971466",
		"itemLabel": "château des Buhards",
		"geo": "Point(-0.690497 47.2954)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971467",
		"itemLabel": "château des Capucins",
		"geo": "Point(6.63361 48.3503)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971468",
		"itemLabel": "château des Cars",
		"geo": "Point(1.07333 45.6797)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971470",
		"itemLabel": "château des Chaulets",
		"geo": "Point(3.20853 46.5201)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971471",
		"itemLabel": "château des Chevennes",
		"geo": "Point(3.51528 46.4881)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971472",
		"itemLabel": "château des Baux",
		"geo": "Point(4.796944444 43.744444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971474",
		"itemLabel": "château des Comtes de Comminges de Bramevaque",
		"geo": "Point(0.574222 42.976)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971475",
		"itemLabel": "château des Chauveaux",
		"geo": "Point(0.42583333 45.08583333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971477",
		"itemLabel": "château des Coutures",
		"geo": "Point(-0.0552 47.3345)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971480",
		"itemLabel": "château des Célestins",
		"geo": "Point(4.73753 45.2679)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971482",
		"itemLabel": "château des Dorides",
		"geo": "Point(-0.530289 46.9324)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971483",
		"itemLabel": "château des Ducs",
		"geo": "Point(-0.01972 48.7431)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971484",
		"itemLabel": "château des Ducs d'Alençon",
		"geo": "Point(0.0831 48.4296)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971487",
		"itemLabel": "château des Essertaux",
		"geo": "Point(4.71056 46.3294)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971488",
		"itemLabel": "château des Faugs",
		"geo": "Point(4.67972 44.9181)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971489",
		"itemLabel": "château des Feugerets",
		"geo": "Point(0.58972 48.3356)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971490",
		"itemLabel": "château des Girodeaux",
		"geo": "Point(3.32497 46.5079)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971492",
		"itemLabel": "château des Gouttes",
		"geo": "Point(3.58811 46.4233)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971493",
		"itemLabel": "château des Guichardots",
		"geo": "Point(3.36944 46.3913)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971494",
		"itemLabel": "château des Gringuenières",
		"geo": "Point(-0.21972 47.7294)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971495",
		"itemLabel": "château des Guillet-Monthoux",
		"geo": "Point(6.48013 46.3723)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971497",
		"itemLabel": "château des Hayes Gasselin",
		"geo": "Point(-0.936537 47.174)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971500",
		"itemLabel": "château des Guilhem",
		"geo": "Point(3.428333333 43.629722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971502",
		"itemLabel": "château des Jaubertes",
		"geo": "Point(-0.194184 44.5607)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971507",
		"itemLabel": "château des Magnans",
		"geo": "Point(6.74287 44.4178)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971509",
		"itemLabel": "château des Lions",
		"geo": "Point(2.11149 48.8784)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971516",
		"itemLabel": "château des Moines",
		"geo": "Point(4.76094 44.6558)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971518",
		"itemLabel": "château des Millets",
		"geo": "Point(3.89042 46.3953)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971525",
		"itemLabel": "château des Noyers",
		"geo": "Point(-0.487894 47.2355)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971528",
		"itemLabel": "château des Mesnuls",
		"geo": "Point(1.83333 48.7558)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971533",
		"itemLabel": "château des Perrais",
		"geo": "Point(0.11 47.8481)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971535",
		"itemLabel": "château des Pins",
		"geo": "Point(0.39056 45.8208)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971538",
		"itemLabel": "château des Ponts-de-Cé",
		"geo": "Point(-0.525628 47.4252)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971541",
		"itemLabel": "château des Quat'Sos",
		"geo": "Point(-0.04333333 44.58138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971549",
		"itemLabel": "château des Rosiers",
		"geo": "Point(4.74636 49.2826)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971550",
		"itemLabel": "château des Roure",
		"geo": "Point(4.40218 44.3509)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971551",
		"itemLabel": "château des Rues",
		"geo": "Point(-0.664651 47.6956)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971552",
		"itemLabel": "château des Sacrots",
		"geo": "Point(3.16494 46.6054)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971553",
		"itemLabel": "château des Sallèles",
		"geo": "Point(3.18 44.4397)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971554",
		"itemLabel": "château des Rudel",
		"geo": "Point(-0.66583333 45.13)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971555",
		"itemLabel": "château des Saptes",
		"geo": "Point(2.40288 43.2614)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971558",
		"itemLabel": "château des Stuarts",
		"geo": "Point(2.44101 47.4889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971559",
		"itemLabel": "château des Stuart",
		"geo": "Point(3.94545 47.8925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971560",
		"itemLabel": "château des Templiers",
		"geo": "Point(3.135794 43.982461)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971565",
		"itemLabel": "château des Timbrieux",
		"geo": "Point(-2.58417 47.8697)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971567",
		"itemLabel": "château des Tours-Saint-Laurent",
		"geo": "Point(1.89417 44.865)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971568",
		"itemLabel": "château des Tours",
		"geo": "Point(4.71899 45.9344)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971572",
		"itemLabel": "château des Tours",
		"geo": "Point(0.11944444 44.92527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971579",
		"itemLabel": "château des ducs de La Trémoille",
		"geo": "Point(-0.2173 46.9709)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971580",
		"itemLabel": "château des ducs de Lorraine",
		"geo": "Point(6.3583 49.4406)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971582",
		"itemLabel": "château des vicomtes de Limoges",
		"geo": "Point(1.1417 45.7944)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971583",
		"itemLabel": "château des ducs de Joyeuse",
		"geo": "Point(2.254166666 42.945)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971584",
		"itemLabel": "château des Échardons",
		"geo": "Point(3.15611 46.6042)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971586",
		"itemLabel": "château des ducs de Savoie",
		"geo": "Point(5.91778 45.5644)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971587",
		"itemLabel": "château des Éclaz",
		"geo": "Point(5.60396 45.8249)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971588",
		"itemLabel": "château des Écossays",
		"geo": "Point(3.23969 46.4507)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971589",
		"itemLabel": "château des Étangs",
		"geo": "Point(0.46583 47.8064)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971590",
		"itemLabel": "château des évêques d'Alet",
		"geo": "Point(2.2345 43.0327)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971592",
		"itemLabel": "château des Évêques-du-Puy",
		"geo": "Point(4.16889 45.2925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971593",
		"itemLabel": "château des évêques de Troyes",
		"geo": "Point(4.00691 48.3613)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971594",
		"itemLabel": "château du Bartas",
		"geo": "Point(0.925556 43.7244)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971595",
		"itemLabel": "château du Bas",
		"geo": "Point(3.542152 49.33209)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971596",
		"itemLabel": "château du Bas-Plessis",
		"geo": "Point(-0.9861 47.2974)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971598",
		"itemLabel": "château du Bellay",
		"geo": "Point(0.018411 47.3144)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971600",
		"itemLabel": "château du Beyrat",
		"geo": "Point(3.10172 46.1888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971602",
		"itemLabel": "château du Bois",
		"geo": "Point(-0.550159 47.5777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971604",
		"itemLabel": "château du Bois-Guignot",
		"geo": "Point(-0.792657 47.4946)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971606",
		"itemLabel": "château du Bois-Gélin",
		"geo": "Point(-1.1275 47.715)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971608",
		"itemLabel": "château du Bois-Rouaud",
		"geo": "Point(-1.8576 47.1161)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971610",
		"itemLabel": "château du Birkenfels",
		"geo": "Point(7.384166666 48.429444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971611",
		"itemLabel": "château du Bois Saumoussay",
		"geo": "Point(-0.070521 47.182)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971613",
		"itemLabel": "château du Bois de Sanzay",
		"geo": "Point(-0.186111 47.065)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971615",
		"itemLabel": "château du Bois du Maine",
		"geo": "Point(-0.5179 48.4973)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971618",
		"itemLabel": "château du Bosc",
		"geo": "Point(2.38 44.16)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971623",
		"itemLabel": "château du Bosquet",
		"geo": "Point(4.58323 44.2986)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971624",
		"itemLabel": "château du Bouchat",
		"geo": "Point(3.16967 46.368)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971625",
		"itemLabel": "château du Bouchet",
		"geo": "Point(-0.013218 47.5304)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971629",
		"itemLabel": "château du Bousquet",
		"geo": "Point(4.76404 44.8263)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971630",
		"itemLabel": "château du Bousquet",
		"geo": "Point(2.8076 44.6568)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971632",
		"itemLabel": "château du Bourbet",
		"geo": "Point(0.36194444 45.4025)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971633",
		"itemLabel": "château du Boy",
		"geo": "Point(3.56194 44.4919)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971635",
		"itemLabel": "château du Breuil",
		"geo": "Point(-0.15361 45.5728)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971636",
		"itemLabel": "château du Bousquet",
		"geo": "Point(1.5093 44.4562)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971639",
		"itemLabel": "château du Bruget",
		"geo": "Point(4.24501 44.6325)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971642",
		"itemLabel": "château du Buisson",
		"geo": "Point(3.42507 49.1545)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971643",
		"itemLabel": "château du Buisson de May",
		"geo": "Point(1.3295 49.0083)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971645",
		"itemLabel": "château du Carpia",
		"geo": "Point(-0.104203 44.5437)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971647",
		"itemLabel": "château du Castelet des Crozes",
		"geo": "Point(1.9843 43.3496)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971648",
		"itemLabel": "château du Castellas",
		"geo": "Point(3.86778 44.0375)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971649",
		"itemLabel": "château du Cayla",
		"geo": "Point(2.2709 44.2051)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971650",
		"itemLabel": "château du Cengle",
		"geo": "Point(6.10325 45.7409)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971651",
		"itemLabel": "château du Chaffaut",
		"geo": "Point(6.14988 44.0377)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971652",
		"itemLabel": "château du Chambon",
		"geo": "Point(1.45 46.1017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971653",
		"itemLabel": "château du Chambon",
		"geo": "Point(3.467777777 45.142222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971654",
		"itemLabel": "château du Champ",
		"geo": "Point(3.85111 44.4708)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971661",
		"itemLabel": "château du Châtelard (Savoie)",
		"geo": "Point(6.13744 45.6802)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971663",
		"itemLabel": "château du Clairay",
		"geo": "Point(-1.24192 47.1535)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971664",
		"itemLabel": "château du Claux",
		"geo": "Point(1.36103 44.9449)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971667",
		"itemLabel": "château du Cluzeau",
		"geo": "Point(2.62742 46.4304)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971668",
		"itemLabel": "château du Colombier",
		"geo": "Point(2.5297 44.4877)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971670",
		"itemLabel": "château du Coudray-Montbault",
		"geo": "Point(-0.580366 47.1389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971671",
		"itemLabel": "château du Creux",
		"geo": "Point(2.65647 46.5503)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940193",
		"itemLabel": "château de Jallerange",
		"geo": "Point(5.7175 47.2533)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940198",
		"itemLabel": "château de la Magnanne",
		"geo": "Point(-1.62005 48.287)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940200",
		"itemLabel": "château de Lutrin",
		"geo": "Point(5.80432 45.6779)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940202",
		"itemLabel": "château de Landsberg",
		"geo": "Point(7.51747 48.4504)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940213",
		"itemLabel": "château de la Leonardsau",
		"geo": "Point(7.443119 48.469633)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940222",
		"itemLabel": "château de Reichenberg",
		"geo": "Point(7.33757 48.2144)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940225",
		"itemLabel": "château de Reichenstein",
		"geo": "Point(7.280303 48.177326)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940228",
		"itemLabel": "château de Reinach",
		"geo": "Point(7.22431 47.5981)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940231",
		"itemLabel": "château de Reichenstein",
		"geo": "Point(7.2803 48.1773)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940233",
		"itemLabel": "château de Mittelhausen",
		"geo": "Point(7.6298 48.7061)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940242",
		"itemLabel": "château de Rathsamhausen",
		"geo": "Point(7.40679 48.461)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940250",
		"itemLabel": "château de Sucy-en-Brie",
		"geo": "Point(2.52389 48.7703)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940252",
		"itemLabel": "château de Valmate",
		"geo": "Point(1.49813 45.9864)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940254",
		"itemLabel": "château des comtes de Montbéliard-Wurtemberg",
		"geo": "Point(7.2992 48.1663)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940257",
		"itemLabel": "château de Wahlenbourg",
		"geo": "Point(7.27315 48.0388)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940259",
		"itemLabel": "château de Weckmund",
		"geo": "Point(7.27354 48.0385)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940263",
		"itemLabel": "château des Hattstatt-Schauenbourg",
		"geo": "Point(7.2016 48.0361)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940265",
		"itemLabel": "château de Walbach",
		"geo": "Point(7.2209 48.0646)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940269",
		"itemLabel": "château de Werde",
		"geo": "Point(7.6375 48.388)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940274",
		"itemLabel": "château de Scharrachbergheim",
		"geo": "Point(7.49548 48.5946)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940280",
		"itemLabel": "château de Thanvillé",
		"geo": "Point(7.3453 48.3231)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940287",
		"itemLabel": "château de Ségur",
		"geo": "Point(1.30472 45.4303)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940289",
		"itemLabel": "château de Scey",
		"geo": "Point(6.0833 47.0956)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940291",
		"itemLabel": "château de Ville-sur-Saulx",
		"geo": "Point(5.05539 48.7115)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940297",
		"itemLabel": "château du Lude",
		"geo": "Point(1.84643 47.7169)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940299",
		"itemLabel": "château épiscopal de Benfeld",
		"geo": "Point(7.5962 48.3708)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940302",
		"itemLabel": "château du Geisberg",
		"geo": "Point(7.9538 49.014)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940304",
		"itemLabel": "château du Warthenberg",
		"geo": "Point(7.3768 48.7946)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940317",
		"itemLabel": "château de Féternes",
		"geo": "Point(6.53888 46.3522)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940318",
		"itemLabel": "château de la Hallière",
		"geo": "Point(1.12111 48.5172)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940321",
		"itemLabel": "château Hervé",
		"geo": "Point(7.53313 48.5606)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940323",
		"itemLabel": "château Fabvier",
		"geo": "Point(7.39076 48.2523)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940326",
		"itemLabel": "château du Garrané",
		"geo": "Point(0.547428 43.5135)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940331",
		"itemLabel": "château d'Étrabonne",
		"geo": "Point(5.7431 47.2342)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940334",
		"itemLabel": "château d'Hauterive",
		"geo": "Point(3.2328 45.5356)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940336",
		"itemLabel": "château de Glane",
		"geo": "Point(0.952222 45.3314)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940343",
		"itemLabel": "château Lacour de Sainte-Marie-aux-Mines",
		"geo": "Point(7.17232 48.2428)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940346",
		"itemLabel": "château Klinglin",
		"geo": "Point(7.71478 48.5328)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940349",
		"itemLabel": "château de Noaillan",
		"geo": "Point(-0.368868 44.4796)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940351",
		"itemLabel": "château de Montjoie-le-Château",
		"geo": "Point(6.9008 47.3511)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940353",
		"itemLabel": "château de Pipet",
		"geo": "Point(4.88164 45.5245)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940355",
		"itemLabel": "château de Recologne",
		"geo": "Point(5.83 47.275)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940357",
		"itemLabel": "château Saint-Rémy d'Altenstadt",
		"geo": "Point(7.99532 49.0267)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940359",
		"itemLabel": "château Teutsch",
		"geo": "Point(7.3637 48.9268)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940363",
		"itemLabel": "château de Seissan",
		"geo": "Point(0.593503 43.4906)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940368",
		"itemLabel": "château Sattler",
		"geo": "Point(6.84112 47.5034)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940370",
		"itemLabel": "château du Chillou",
		"geo": "Point(0.428531 46.9487)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940372",
		"itemLabel": "château de Bertichères",
		"geo": "Point(1.85562 49.2699)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940377",
		"itemLabel": "château Wagenbourg",
		"geo": "Point(7.24197 47.9593)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940382",
		"itemLabel": "château de Chevroz",
		"geo": "Point(5.9969 47.3353)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940384",
		"itemLabel": "château de Chevigney-sur-l'Ognon",
		"geo": "Point(5.8388 47.2989)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940434",
		"itemLabel": "château de Quingey",
		"geo": "Point(5.8831 47.1024)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940436",
		"itemLabel": "château de Noironte",
		"geo": "Point(5.8753 47.2731)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940439",
		"itemLabel": "château de Paroy",
		"geo": "Point(5.8828 47.0417)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940443",
		"itemLabel": "château de Dachstein",
		"geo": "Point(7.53277 48.562)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940465",
		"itemLabel": "château de Contenson",
		"geo": "Point(3.849722222 45.898888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940467",
		"itemLabel": "château de Prat",
		"geo": "Point(1.0158 43.0302)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940474",
		"itemLabel": "château de Salveterra",
		"geo": "Point(2.86157 42.8764)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940476",
		"itemLabel": "château de Beaucens",
		"geo": "Point(-0.059639 42.9718)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940482",
		"itemLabel": "château d'Aspremont",
		"geo": "Point(-1.10039 43.5477)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940485",
		"itemLabel": "château du Vigneau",
		"geo": "Point(-1.46967 43.5056)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940488",
		"itemLabel": "château de Corbère",
		"geo": "Point(2.6575 42.6503)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940494",
		"itemLabel": "château de Pujols",
		"geo": "Point(3.0267 42.5573)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940501",
		"itemLabel": "château de Tautavel",
		"geo": "Point(2.74674 42.8111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940504",
		"itemLabel": "château de Poyaller",
		"geo": "Point(-0.7347 43.717)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940507",
		"itemLabel": "château de Grilly",
		"geo": "Point(6.11486 46.3281)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940508",
		"itemLabel": "château de Virieu",
		"geo": "Point(5.47917 45.4794)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940510",
		"itemLabel": "Château vieux de Clermont (Haute-Savoie)",
		"geo": "Point(5.90935 45.974)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940512",
		"itemLabel": "château de Duingt",
		"geo": "Point(6.20581 45.8287)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940514",
		"itemLabel": "château de Marlioz",
		"geo": "Point(6.00549 46.0339)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940516",
		"itemLabel": "château de Chuet",
		"geo": "Point(6.36423 46.0586)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940518",
		"itemLabel": "château de Montfort (Saint-Sulpice)",
		"geo": "Point(5.86369 45.5695)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940520",
		"itemLabel": "château de Combefort",
		"geo": "Point(6.09665 45.4847)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940521",
		"itemLabel": "château de Montbel",
		"geo": "Point(5.87521 45.4334)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940523",
		"itemLabel": "château d'Apremont (Savoie)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940525",
		"itemLabel": "château de Montmélian",
		"geo": "Point(6.05448 45.5011)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940526",
		"itemLabel": "château de Sandar",
		"geo": "Point(4.766111111 45.833888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940530",
		"itemLabel": "château de Narbonne",
		"geo": "Point(0.493306 45.3352)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940532",
		"itemLabel": "château de Montferrand",
		"geo": "Point(0.865555555 44.749166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940559",
		"itemLabel": "château de Castegens",
		"geo": "Point(-0.023123 44.8755)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940572",
		"itemLabel": "château de Pitray",
		"geo": "Point(-0.288134 44.8259)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940574",
		"itemLabel": "château de Tustal",
		"geo": "Point(-0.388697 44.7853)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940579",
		"itemLabel": "château de Canabazes",
		"geo": "Point(0.810124 44.4943)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940593",
		"itemLabel": "château de Malevirade",
		"geo": "Point(0.122222 44.3775)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940607",
		"itemLabel": "château de Bachen",
		"geo": "Point(-0.3017 43.7189)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940609",
		"itemLabel": "château de Poyanne",
		"geo": "Point(-0.814722 43.7572)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940613",
		"itemLabel": "château de Beyries",
		"geo": "Point(-0.651989 43.5631)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940617",
		"itemLabel": "château du Lau",
		"geo": "Point(-0.340833 43.7264)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940620",
		"itemLabel": "château de Beauvoir",
		"geo": "Point(3.63486 46.4666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940626",
		"itemLabel": "château de la Mothe",
		"geo": "Point(3.09428 46.1481)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943696",
		"itemLabel": "château de Mons",
		"geo": "Point(3.91564 45.0342)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943706",
		"itemLabel": "château de Fresney-le-Puceux",
		"geo": "Point(-0.37028 49.0619)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943708",
		"itemLabel": "château de Fontaine-Étoupefour",
		"geo": "Point(-0.44278 49.1375)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943729",
		"itemLabel": "château de Rabanesse",
		"geo": "Point(3.08702 45.7687)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943739",
		"itemLabel": "château de Courseulles",
		"geo": "Point(-0.45972 49.33)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943746",
		"itemLabel": "château de Lasson",
		"geo": "Point(-0.4611 49.2344)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943755",
		"itemLabel": "château de Grandchamp-le-Château",
		"geo": "Point(0.07722 49.0811)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943763",
		"itemLabel": "château d'Antigny",
		"geo": "Point(4.5736 47.124)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943768",
		"itemLabel": "château de Chambois",
		"geo": "Point(0.10694 48.8056)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943776",
		"itemLabel": "château de Vassy",
		"geo": "Point(-1.17044 48.7093)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943788",
		"itemLabel": "château de Courcy",
		"geo": "Point(-1.3106 49.4934)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943792",
		"itemLabel": "château de Flamanville",
		"geo": "Point(-1.87026 49.5269)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943801",
		"itemLabel": "château d'Essarois",
		"geo": "Point(4.784444444 47.754444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943804",
		"itemLabel": "château de Lusigny-sur-Ouche",
		"geo": "Point(4.6739 47.0882)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943821",
		"itemLabel": "château de Corabœuf",
		"geo": "Point(4.63882 47.0238)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943832",
		"itemLabel": "château de Coulon",
		"geo": "Point(3.73723 47.2059)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943833",
		"itemLabel": "château de Besne",
		"geo": "Point(3.80882 47.0652)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943846",
		"itemLabel": "château de Villemenant",
		"geo": "Point(3.20601 47.0936)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943847",
		"itemLabel": "château de Prémery",
		"geo": "Point(3.33151 47.1751)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943852",
		"itemLabel": "château de Savigny-le-Vieux",
		"geo": "Point(4.397777777 47.006388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943860",
		"itemLabel": "château de Coatfrec",
		"geo": "Point(-3.42216 48.709)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943869",
		"itemLabel": "château de Kercadio",
		"geo": "Point(-3.13778 47.6417)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943872",
		"itemLabel": "château de Saragosse",
		"geo": "Point(2.106666666 47.076111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943875",
		"itemLabel": "château de l'Isle-sur-Arnon",
		"geo": "Point(2.2093 46.7034)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943879",
		"itemLabel": "château du Jonchet",
		"geo": "Point(1.27523 47.9847)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943881",
		"itemLabel": "château du Bouchet",
		"geo": "Point(1.172777777 46.718611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943882",
		"itemLabel": "château de Vauventriers",
		"geo": "Point(1.51749 48.466)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943886",
		"itemLabel": "château de Turly",
		"geo": "Point(2.4747 47.1237)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943887",
		"itemLabel": "château de Beaumont-la-Ronce",
		"geo": "Point(0.67 47.570833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943897",
		"itemLabel": "château de Détilly",
		"geo": "Point(0.164709 47.1999)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943910",
		"itemLabel": "château de Lierville",
		"geo": "Point(1.41416 47.9344)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943911",
		"itemLabel": "château de la Touanne",
		"geo": "Point(1.65177 47.8717)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943913",
		"itemLabel": "château de Châteauneuf-sur-Loire",
		"geo": "Point(2.21672 47.8641)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943919",
		"itemLabel": "château de Brugny",
		"geo": "Point(3.88827 48.994)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943920",
		"itemLabel": "château de Courcelles",
		"geo": "Point(3.99003 49.2686)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943925",
		"itemLabel": "château de Corcondray",
		"geo": "Point(6.0575 47.0878)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943926",
		"itemLabel": "château de Saint-Dizier",
		"geo": "Point(4.95302 48.6364)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943927",
		"itemLabel": "château de Vitry-la-Ville",
		"geo": "Point(4.46268 48.8412)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943931",
		"itemLabel": "château de Gy",
		"geo": "Point(5.8116 47.4041)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943933",
		"itemLabel": "château-Dessous",
		"geo": "Point(5.7514 47.7926)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943936",
		"itemLabel": "château des Bouly",
		"geo": "Point(6.2758 47.885)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943939",
		"itemLabel": "château de Bourguignon-lès-Conflans",
		"geo": "Point(6.1655 47.8068)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943941",
		"itemLabel": "château de Frasne-le-Château",
		"geo": "Point(5.8949 47.4633)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943943",
		"itemLabel": "château de Clairefontaine",
		"geo": "Point(6.0834 47.8575)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943947",
		"itemLabel": "château de la Colombière",
		"geo": "Point(5.6789 47.6343)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943950",
		"itemLabel": "château de Beaujeu",
		"geo": "Point(5.67732 47.505)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943954",
		"itemLabel": "château de Bougey",
		"geo": "Point(5.8597 47.7802)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943957",
		"itemLabel": "château de Buthiers",
		"geo": "Point(6.0328 47.347)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943959",
		"itemLabel": "château de Gézier",
		"geo": "Point(5.8961 47.3562)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943961",
		"itemLabel": "château de Malans",
		"geo": "Point(5.5875 47.2637)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943966",
		"itemLabel": "château Grillot",
		"geo": "Point(5.5134 47.6156)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943969",
		"itemLabel": "château de Montcourt",
		"geo": "Point(5.9573 47.9291)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943971",
		"itemLabel": "château de Montjustin",
		"geo": "Point(6.3764 47.6137)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943974",
		"itemLabel": "château de Montureux-lès-Gray",
		"geo": "Point(5.6388 47.5061)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943978",
		"itemLabel": "château des Forges",
		"geo": "Point(5.5538 47.2867)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943980",
		"itemLabel": "château de Boulot",
		"geo": "Point(5.9626 47.3497)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943985",
		"itemLabel": "château de Fallon",
		"geo": "Point(6.4849 47.5084)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943987",
		"itemLabel": "château-Dessus",
		"geo": "Point(5.7507 47.7934)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943990",
		"itemLabel": "château de Mantoche",
		"geo": "Point(5.5313 47.4199)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943992",
		"itemLabel": "château de Boult",
		"geo": "Point(6.0015 47.3825)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15943997",
		"itemLabel": "château de Cult",
		"geo": "Point(5.737 47.3131)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944000",
		"itemLabel": "château de Levrecey",
		"geo": "Point(6.0849 47.5472)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944006",
		"itemLabel": "château de Fondremand",
		"geo": "Point(6.0258 47.4753)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944009",
		"itemLabel": "château de Contréglise",
		"geo": "Point(6.0383 47.8244)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944014",
		"itemLabel": "château de Saint-Remy",
		"geo": "Point(6.0911 47.8309)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944023",
		"itemLabel": "château de Passavant-la-Rochère",
		"geo": "Point(6.0378 47.9678)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944028",
		"itemLabel": "château de Quers",
		"geo": "Point(6.4247 47.7354)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944031",
		"itemLabel": "château Rouillaud",
		"geo": "Point(5.563 47.2785)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944040",
		"itemLabel": "château de Pont-sur-l'Ognon",
		"geo": "Point(6.3884 47.5212)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944048",
		"itemLabel": "château de La Rochelle",
		"geo": "Point(5.7319 47.7458)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944057",
		"itemLabel": "château de Villefrancon",
		"geo": "Point(5.7453 47.4022)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944065",
		"itemLabel": "château d'Ouge",
		"geo": "Point(5.7051 47.7966)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944075",
		"itemLabel": "château de Pesmes",
		"geo": "Point(5.5626 47.2786)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944083",
		"itemLabel": "château de Vellefaux",
		"geo": "Point(6.1387 47.5525)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944091",
		"itemLabel": "château de Rupt-sur-Saône",
		"geo": "Point(5.928055555 47.645833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944099",
		"itemLabel": "château de Sorans-lès-Breurey",
		"geo": "Point(6.0439 47.398)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944108",
		"itemLabel": "château de Pin",
		"geo": "Point(5.8659 47.3218)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944116",
		"itemLabel": "château Mugnier",
		"geo": "Point(5.8938 47.4619)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944125",
		"itemLabel": "château de Scey-sur-Saône",
		"geo": "Point(5.9622 47.6612)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944133",
		"itemLabel": "château de Venère",
		"geo": "Point(5.6765 47.3599)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944142",
		"itemLabel": "château de Vregille",
		"geo": "Point(5.8921 47.3186)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944152",
		"itemLabel": "château de Seveux",
		"geo": "Point(5.7455 47.5565)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944161",
		"itemLabel": "château de Mutigney",
		"geo": "Point(5.5455 47.278)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944193",
		"itemLabel": "château du Blanc-Buisson",
		"geo": "Point(0.564412 48.9389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944248",
		"itemLabel": "château du Tronchet",
		"geo": "Point(2.05891 48.4377)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944275",
		"itemLabel": "château de Touteville",
		"geo": "Point(2.35766 49.1311)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944276",
		"itemLabel": "château de Viarmes",
		"geo": "Point(2.36877 49.1259)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944292",
		"itemLabel": "château de Neuville-sur-Oise",
		"geo": "Point(2.061111111 49.013055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944300",
		"itemLabel": "château de Pinceloup",
		"geo": "Point(1.88253 48.5823)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944301",
		"itemLabel": "château de la Couharde",
		"geo": "Point(1.7625 48.8042)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944303",
		"itemLabel": "château du Pont",
		"geo": "Point(2.11793 48.8582)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944307",
		"itemLabel": "château d'Allègre",
		"geo": "Point(4.266901 44.19562)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944310",
		"itemLabel": "château de Sommières",
		"geo": "Point(4.09187 43.7827)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944311",
		"itemLabel": "château de Pouzilhac",
		"geo": "Point(4.57948 44.0415)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944321",
		"itemLabel": "château d'Ottange",
		"geo": "Point(6.02679 49.4413)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944322",
		"itemLabel": "château de Bétange",
		"geo": "Point(6.117 49.338)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944333",
		"itemLabel": "château de Rorthey",
		"geo": "Point(5.62167 48.3908)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944336",
		"itemLabel": "château de Graves",
		"geo": "Point(2.0275 44.3658)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944338",
		"itemLabel": "château de Marsan",
		"geo": "Point(0.72116 43.6556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944342",
		"itemLabel": "château de Foucaud",
		"geo": "Point(1.89917 43.9014)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944344",
		"itemLabel": "château de Castelfranc",
		"geo": "Point(2.29225 43.7251)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944346",
		"itemLabel": "château de Villebrumier",
		"geo": "Point(1.45002 43.9066)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944348",
		"itemLabel": "château de Rametz",
		"geo": "Point(3.77392 50.2983)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944374",
		"itemLabel": "château des Cloîtres",
		"geo": "Point(-0.7266 47.219)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944391",
		"itemLabel": "château du Pin",
		"geo": "Point(-0.8503 47.4275)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944393",
		"itemLabel": "château de la Roche",
		"geo": "Point(-0.9628 47.7017)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944399",
		"itemLabel": "château de Verney",
		"geo": "Point(-0.655463 47.6671)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944404",
		"itemLabel": "château de Varennes",
		"geo": "Point(-0.6496 47.3853)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944409",
		"itemLabel": "château de Montmirail",
		"geo": "Point(0.790277777 48.103055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944411",
		"itemLabel": "château d'Eporcé",
		"geo": "Point(0.03139 48.05044)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q13219119",
		"itemLabel": "château de Meywihr",
		"geo": "Point(7.2811 48.1224)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q13220453",
		"itemLabel": "château Saint-Léon",
		"geo": "Point(7.30607222 48.04266944)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q13220453",
		"itemLabel": "château Saint-Léon",
		"geo": "Point(7.30666667 48.04361111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q13360318",
		"itemLabel": "château de la Grange Fort",
		"geo": "Point(3.28464121 45.5092492)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q13361782",
		"itemLabel": "château de Romécourt",
		"geo": "Point(6.8312 48.713)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q13398054",
		"itemLabel": "château des Grimaldi",
		"geo": "Point(7.128333 43.580556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q14004696",
		"itemLabel": "château du Burgstall",
		"geo": "Point(7.20975 47.91088889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q14570807",
		"itemLabel": "château de Cuy",
		"geo": "Point(-0.0861 48.7717)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15210404",
		"itemLabel": "château d'Yèvre-le-Châtel",
		"geo": "Point(2.334638 48.160425)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15210404",
		"itemLabel": "château d'Yèvre-le-Châtel",
		"geo": "Point(2.3347 48.1604)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15210463",
		"itemLabel": "Q15210463",
		"geo": "Point(2.50347222 44.52958333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15210482",
		"itemLabel": "Q15210482",
		"geo": "Point(6.05694444 48.4175)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15210487",
		"itemLabel": "Q15210487",
		"geo": "Point(3.88083333 45.43444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15210488",
		"itemLabel": "château de Wangen",
		"geo": "Point(7.46575 48.6171)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15210551",
		"itemLabel": "Q15210551",
		"geo": "Point(-0.1471 48.979)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15214745",
		"itemLabel": "donjon de Niort",
		"geo": "Point(-0.465 46.3253)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15214745",
		"itemLabel": "donjon de Niort",
		"geo": "Point(-0.465 46.32555556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15299100",
		"itemLabel": "château de Fonscolombe",
		"geo": "Point(5.468 43.639)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15459612",
		"itemLabel": "château de Monthimer",
		"geo": "Point(0.451885 48.3935)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15622256",
		"itemLabel": "tours de Cabrenç",
		"geo": "Point(2.5416 42.3655)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15660316",
		"itemLabel": "château de Verreux",
		"geo": "Point(5.7773 46.9057)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15677956",
		"itemLabel": "château des Caramans",
		"geo": "Point(2.52054691 49.00551787)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15714091",
		"itemLabel": "château de Sospel",
		"geo": "Point(7.44744 43.8763)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15813972",
		"itemLabel": "château de Luisandre",
		"geo": "Point(5.418611 45.978056)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15918273",
		"itemLabel": "château de Soye",
		"geo": "Point(6.497 47.4423)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15918342",
		"itemLabel": "château d'Aynac",
		"geo": "Point(1.85054 44.7834)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940029",
		"itemLabel": "château de Cadreils",
		"geo": "Point(0.562 44.006)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940032",
		"itemLabel": "château d'Ars",
		"geo": "Point(5.6794 44.9702)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940034",
		"itemLabel": "château de Brangues",
		"geo": "Point(5.52477 45.6979)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940037",
		"itemLabel": "château du Bordage",
		"geo": "Point(-1.5088 48.259)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940040",
		"itemLabel": "château de Benauge",
		"geo": "Point(-0.267835 44.6646)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940049",
		"itemLabel": "château Bilstein",
		"geo": "Point(7.2217 48.3304)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940057",
		"itemLabel": "château d'Avensac",
		"geo": "Point(0.903824 43.8315)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940061",
		"itemLabel": "château de Bocsozel",
		"geo": "Point(5.30584 45.4192)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940063",
		"itemLabel": "château de Chapdeuil",
		"geo": "Point(0.475319 45.3426)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940066",
		"itemLabel": "château de Châtillon-sur-Lison",
		"geo": "Point(5.9844 47.0636)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940068",
		"itemLabel": "château de Châteauvieux (Alby-sur-Chéran)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940078",
		"itemLabel": "château de Cinne",
		"geo": "Point(5.82478 45.6902)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940082",
		"itemLabel": "château de Châtillon-en-Michaille",
		"geo": "Point(5.79894 46.1461)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940085",
		"itemLabel": "château de Cuchet",
		"geo": "Point(5.37641 45.8829)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940088",
		"itemLabel": "château de Cusy",
		"geo": "Point(6.02539 45.7342)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940093",
		"itemLabel": "château d'Engelbourg",
		"geo": "Point(7.10119 47.8149)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940095",
		"itemLabel": "château d'eau de la gare de Strasbourg",
		"geo": "Point(7.72864 48.5804)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940103",
		"itemLabel": "château d'Urendorf",
		"geo": "Point(7.56382 48.5639)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940105",
		"itemLabel": "château d'Odratzheim",
		"geo": "Point(7.4905 48.6012)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940111",
		"itemLabel": "château d'Osthouse",
		"geo": "Point(7.63927 48.3996)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940118",
		"itemLabel": "château d'Ittenwiller",
		"geo": "Point(7.45371 48.3847)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940131",
		"itemLabel": "château de Chambuet",
		"geo": "Point(5.76458 45.6925)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940135",
		"itemLabel": "château de Bollwiller",
		"geo": "Point(7.26322 47.8621)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940137",
		"itemLabel": "château de Butenheim",
		"geo": "Point(7.515 47.746)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940140",
		"itemLabel": "château de Bonnefontaine",
		"geo": "Point(6.99362 48.9077)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940142",
		"itemLabel": "château de Breuschwickersheim",
		"geo": "Point(7.60461 48.5788)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940146",
		"itemLabel": "château de Boulogne-sur-Mer",
		"geo": "Point(1.6169 50.7256)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940152",
		"itemLabel": "château de Châteaufort",
		"geo": "Point(5.83733 45.9312)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940154",
		"itemLabel": "château de Freundstein",
		"geo": "Point(7.11969 47.8601)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940157",
		"itemLabel": "château et cimetière de Châtenois",
		"geo": "Point(7.39662 48.2696)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940158",
		"itemLabel": "château de Drulingen",
		"geo": "Point(7.18908 48.866)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940160",
		"itemLabel": "château de Frœschwiller",
		"geo": "Point(7.72119 48.9426)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940164",
		"itemLabel": "château de Dietrich",
		"geo": "Point(7.66481 48.93)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940171",
		"itemLabel": "château de la famille d'Eplingen",
		"geo": "Point(7.4767 47.524)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940174",
		"itemLabel": "château de Hegenheim",
		"geo": "Point(7.52866 47.5624)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940176",
		"itemLabel": "château de Heidwiller",
		"geo": "Point(7.23953 47.6587)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940178",
		"itemLabel": "château de Hagueneck",
		"geo": "Point(7.27508 48.0523)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940180",
		"itemLabel": "château de la Cour d'Angleterre",
		"geo": "Point(7.79881 48.6312)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15940187",
		"itemLabel": "château de Grünstein",
		"geo": "Point(7.49754 48.3794)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944412",
		"itemLabel": "château des Carmes",
		"geo": "Point(-0.0748 47.6959)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944414",
		"itemLabel": "château de Bellefille",
		"geo": "Point(-0.0175 47.9375)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944416",
		"itemLabel": "château du Maurier",
		"geo": "Point(0.05125 47.789)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944419",
		"itemLabel": "château de la Groirie",
		"geo": "Point(0.125352 48.0281)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944420",
		"itemLabel": "château de l'Echasserie",
		"geo": "Point(-1.14855 46.9895)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944427",
		"itemLabel": "château de la Sauvagère",
		"geo": "Point(-0.00889 47.9308)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944435",
		"itemLabel": "château de Montépilloy",
		"geo": "Point(2.6994 49.2102)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944437",
		"itemLabel": "château de Thiers-sur-Thève",
		"geo": "Point(2.5714 49.1531)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944441",
		"itemLabel": "château de Fillerval",
		"geo": "Point(2.3127 49.35808)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944444",
		"itemLabel": "château de Fresneaux-Montchevreuil",
		"geo": "Point(2.0084 49.2854)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944445",
		"itemLabel": "château de Montherlant",
		"geo": "Point(2.0491 49.278)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944447",
		"itemLabel": "château d'Alincourt",
		"geo": "Point(1.75903 49.1861)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944448",
		"itemLabel": "château de Foucaucourt",
		"geo": "Point(1.72302 49.9143)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944454",
		"itemLabel": "château d'Ardenne",
		"geo": "Point(-0.0378 45.6626)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944457",
		"itemLabel": "château de Ferrières",
		"geo": "Point(0.5112 45.6765)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944458",
		"itemLabel": "château de la Mercerie",
		"geo": "Point(0.24222 45.5014)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944462",
		"itemLabel": "château du Haut-Clairvaux",
		"geo": "Point(0.418036 46.8259)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944465",
		"itemLabel": "château de la Rigaudière",
		"geo": "Point(-0.966388888 45.654861111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944467",
		"itemLabel": "château du Bois-Doucet",
		"geo": "Point(0.499166666 46.588333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944469",
		"itemLabel": "château de la Chapelle Bellouin",
		"geo": "Point(0.18647 46.9575)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944472",
		"itemLabel": "château de Monthoiron",
		"geo": "Point(0.611748 46.7331)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944473",
		"itemLabel": "château des Robinières",
		"geo": "Point(0.420938 46.8248)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944475",
		"itemLabel": "château des Seigneurs de la Brigue",
		"geo": "Point(7.61481 44.0621)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944477",
		"itemLabel": "château de Gilette",
		"geo": "Point(7.16119 43.8503)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944479",
		"itemLabel": "château de Gréolières",
		"geo": "Point(6.94258 43.7948)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944481",
		"itemLabel": "château de Montfort",
		"geo": "Point(7.10974 43.6789)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944482",
		"itemLabel": "château de Saint-André",
		"geo": "Point(7.28825 43.7456)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944484",
		"itemLabel": "château de Roubion",
		"geo": "Point(7.05171 44.0937)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944485",
		"itemLabel": "château du Rouret",
		"geo": "Point(7.00533 43.6928)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944486",
		"itemLabel": "château de Vayres",
		"geo": "Point(0.390278 46.6607)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944488",
		"itemLabel": "château de Châteaurenard",
		"geo": "Point(4.85569 43.882)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944494",
		"itemLabel": "château de Bouchony",
		"geo": "Point(4.84 43.9675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944497",
		"itemLabel": "château de Cadenet",
		"geo": "Point(5.3712 43.736)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944499",
		"itemLabel": "château de Lauris",
		"geo": "Point(5.3115 43.7459)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944501",
		"itemLabel": "château du Barroux",
		"geo": "Point(5.09944 44.1369)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944503",
		"itemLabel": "château de La Tour-d'Aigues",
		"geo": "Point(5.55011 43.7266)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944509",
		"itemLabel": "château de Genas",
		"geo": "Point(4.93639 44.6119)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944513",
		"itemLabel": "château de Cornillon (Haute-Savoie)",
		"geo": "Point(6.37295 46.0415)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944523",
		"itemLabel": "château d'Uriage",
		"geo": "Point(5.83253 45.1446)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944528",
		"itemLabel": "château de Carron",
		"geo": "Point(6.03278 45.5008)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944548",
		"itemLabel": "château de la Balluère",
		"geo": "Point(-0.1075 47.8986)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15944555",
		"itemLabel": "château du Gros Chesnay",
		"geo": "Point(0.11042 47.8942)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15945427",
		"itemLabel": "château Dampierre",
		"geo": "Point(3.50683 50.3659)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15945822",
		"itemLabel": "château d'eau de Champagnole",
		"geo": "Point(5.9073 46.7461)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15945833",
		"itemLabel": "château d'eau du Lioran",
		"geo": "Point(2.7514 45.0903)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15946085",
		"itemLabel": "château de Brûlon",
		"geo": "Point(-0.23306 47.9658)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15947163",
		"itemLabel": "château de Pizay",
		"geo": "Point(4.70061 46.1381)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15947842",
		"itemLabel": "château de la Marcellière",
		"geo": "Point(0.55972 47.6972)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15957659",
		"itemLabel": "château de Château-Vieux (Cessens)",
		"geo": "Point(5.87528 45.7978)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15957660",
		"itemLabel": "château de Château-Neuf (Cessens)",
		"geo": "Point(5.87331 45.7963)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15957666",
		"itemLabel": "château de Verdun-Dessus",
		"geo": "Point(6.10314 45.5389)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q15992417",
		"itemLabel": "château du Louvre",
		"geo": "Point(2.338 48.8602)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q16010192",
		"itemLabel": "château d'Aiguebelette-le-Lac",
		"geo": "Point(5.81519 45.5358)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q16060434",
		"itemLabel": "Le Château des Lumières"
	},
	{
		"item": "http://www.wikidata.org/entity/Q16325207",
		"itemLabel": "château de Meximieux",
		"geo": "Point(5.1908 45.9072)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q16507456",
		"itemLabel": "château du Villard (Savoie)",
		"geo": "Point(5.74568 45.643)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q16854290",
		"itemLabel": "château d'Hauterives",
		"geo": "Point(5.0293 45.2539)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q16937101",
		"itemLabel": "château des ducs de Bourgogne",
		"geo": "Point(4.5775 47.8589)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17031222",
		"itemLabel": "Q17031222"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17100452",
		"itemLabel": "Q17100452"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17100993",
		"itemLabel": "château de Montbrun",
		"geo": "Point(1.900316 44.50564)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17265852",
		"itemLabel": "château de la Roca d'Anyer",
		"geo": "Point(2.2807 42.5266)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17346988",
		"itemLabel": "château d'Arlod",
		"geo": "Point(5.82265 46.0938)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17346995",
		"itemLabel": "château des Ifs",
		"geo": "Point(7.287342 48.135396)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17402091",
		"itemLabel": "château de Savenès",
		"geo": "Point(1.20097 43.833642)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17402098",
		"itemLabel": "château de Montmorin",
		"geo": "Point(3.360585 45.69511)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17596365",
		"itemLabel": "Fort de Marquixanes",
		"geo": "Point(2.484842 42.6413)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17596395",
		"itemLabel": "château de Molitg-les-Bains",
		"geo": "Point(2.386667 42.660833)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17597013",
		"itemLabel": "château de Caudiès-de-Conflent",
		"geo": "Point(2.162222 42.567222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17609196",
		"itemLabel": "château de Saint-Maurice-de-Rémens",
		"geo": "Point(5.2752 45.9565)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17679515",
		"itemLabel": "donjon de Fauguerolles",
		"geo": "Point(0.700486111 44.291472222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q17769884",
		"itemLabel": "château de Combebonnet",
		"geo": "Point(0.87826 44.253)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18004204",
		"itemLabel": "castrum de La Llagonne",
		"geo": "Point(2.121411111 42.526641666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18004956",
		"itemLabel": "château de Mollet",
		"geo": "Point(2.56643 42.4463)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18006070",
		"itemLabel": "château de Carol",
		"geo": "Point(1.8437 42.4986)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18046588",
		"itemLabel": "fortifications romaines des Cluses",
		"geo": "Point(2.843333333 42.482222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18624184",
		"itemLabel": "Q18624184",
		"geo": "Point(2.93197 49.9291)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18736780",
		"itemLabel": "château de Charousse",
		"geo": "Point(6.674083 45.929863)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18736818",
		"itemLabel": "château de Tournebu",
		"geo": "Point(-0.343056 48.9717)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19107670",
		"itemLabel": "château de Fournils",
		"geo": "Point(0.287726 45.024785)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19116672",
		"itemLabel": "château de Virelade",
		"geo": "Point(-0.381608 44.65525)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19116827",
		"itemLabel": "château de Grenade",
		"geo": "Point(-0.460964 44.633417)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19152931",
		"itemLabel": "château de Cornod",
		"geo": "Point(5.552462 46.312097)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19257158",
		"itemLabel": "Q19257158"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19257624",
		"itemLabel": "château de Puymorens",
		"geo": "Point(1.824569444 42.543744444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19406851",
		"itemLabel": "Castellas de Montpeyroux",
		"geo": "Point(3.51012 43.7056)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19406879",
		"itemLabel": "château de Pierre II",
		"geo": "Point(-3.15015 48.5599)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19406880",
		"itemLabel": "château de Poizieu",
		"geo": "Point(5.215556 45.7025)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19607191",
		"itemLabel": "château de Triviers",
		"geo": "Point(5.99075 45.5455)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19607195",
		"itemLabel": "château de Marcillé-Robert",
		"geo": "Point(-1.356803 47.95048)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19760046",
		"itemLabel": "les Trois-Châteaux de Ribeauvillé"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19833234",
		"itemLabel": "fortin de Rancé",
		"geo": "Point(4.8426 45.897313)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19853537",
		"itemLabel": "château de Chapeau cornu",
		"geo": "Point(5.4042564 45.63566319)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q19945357",
		"itemLabel": "château des Comtes de Challes",
		"geo": "Point(5.9878 45.5543)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20103778",
		"itemLabel": "château de Bisqueytan",
		"geo": "Point(-0.285977 44.817334)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20104678",
		"itemLabel": "ancien château des Comtes de Conflent-Cerdagne",
		"geo": "Point(2.3812 42.5668)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20669908",
		"itemLabel": "château de Lassay",
		"geo": "Point(0.559256 48.0256)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20671772",
		"itemLabel": "château du Cingle‎",
		"geo": "Point(5.279607 45.775714)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20706299",
		"itemLabel": "Maison forte de la Veyrie",
		"geo": "Point(5.862349 45.257983)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20895541",
		"itemLabel": "château de Mérieu",
		"geo": "Point(5.505846 45.736447)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20895548",
		"itemLabel": "château de Montplaisant",
		"geo": "Point(5.281398 45.670348)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20895594",
		"itemLabel": "château de Lancin",
		"geo": "Point(5.407618 45.726294)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20950496",
		"itemLabel": "château de la Tour",
		"geo": "Point(5.194347 45.651439)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20950517",
		"itemLabel": "château de Certeau",
		"geo": "Point(5.180907 45.651176)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20955862",
		"itemLabel": "château de Frontonas",
		"geo": "Point(5.188385 45.646969)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20957013",
		"itemLabel": "tour de Moras",
		"geo": "Point(5.259117 45.687008)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20957256",
		"itemLabel": "château de Mépieu",
		"geo": "Point(5.44825 45.748861)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20959952",
		"itemLabel": "château de Veyssilieu",
		"geo": "Point(5.218495 45.679767)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20985535",
		"itemLabel": "château de  Corneilla-del-Vercol",
		"geo": "Point(2.948933333 42.625675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20985577",
		"itemLabel": "château de Saint-Nazaire",
		"geo": "Point(2.948933333 42.625675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q20991072",
		"itemLabel": "château de la Barge",
		"geo": "Point(4.691017 45.746283)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21074586",
		"itemLabel": "château de Cassaigne",
		"geo": "Point(0.335748 43.90851)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21083496",
		"itemLabel": "Châtel de Theys",
		"geo": "Point(5.996944 45.3025)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21127002",
		"itemLabel": "Q21127002",
		"geo": "Point(2.969326944 42.627941111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21127003",
		"itemLabel": "château d'Ortaffa",
		"geo": "Point(2.926194444 42.580083333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21127043",
		"itemLabel": "Q21127043",
		"geo": "Point(2.869805555 42.619388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21129877",
		"itemLabel": "château de Saint-Cyprien",
		"geo": "Point(3.0025 42.616388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21152896",
		"itemLabel": "château de Latour-Bas-Elne",
		"geo": "Point(3.001486111 42.605923055)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21152898",
		"itemLabel": "château de Théza",
		"geo": "Point(2.952096111 42.637696111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21192831",
		"itemLabel": "château de Sainte-Marie",
		"geo": "Point(3.016461111 42.727728055)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21192875",
		"itemLabel": "Q21192875",
		"geo": "Point(2.9814 42.760136111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21199199",
		"itemLabel": "Château de Torreilles",
		"geo": "Point(2.992536111 42.755401944)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21294298",
		"itemLabel": "château de la Serre",
		"geo": "Point(2.103611111 43.573055556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21294321",
		"itemLabel": "château de Salvagnac",
		"geo": "Point(1.6875 43.905277778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21294322",
		"itemLabel": "château de Sauveterre",
		"geo": "Point(2.553518 43.474103)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21294323",
		"itemLabel": "château de Scopont",
		"geo": "Point(1.805277778 43.584722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21294325",
		"itemLabel": "château de Thuriès",
		"geo": "Point(2.489722222 43.481111111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21294326",
		"itemLabel": "château de Trévien",
		"geo": "Point(2.116944444 44.093888889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21294329",
		"itemLabel": "château de Viviers-lès-Montagnes",
		"geo": "Point(1.85 43.943333333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21294331",
		"itemLabel": "château du Travet",
		"geo": "Point(1.824166667 43.699166667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21427054",
		"itemLabel": "château de Serres",
		"geo": "Point(2.002999 43.807782)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21479909",
		"itemLabel": "château de Saint-Hippolyte",
		"geo": "Point(2.96682 42.784628)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21568894",
		"itemLabel": "Château de Bompas",
		"geo": "Point(2.933938888 42.732611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21674768",
		"itemLabel": "château fort de Conflans",
		"geo": "Point(6.396516 45.670459)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q21907053",
		"itemLabel": "château fort de Chateau-Chalon",
		"geo": "Point(5.629469 46.755139)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22249431",
		"itemLabel": "château de Varennes",
		"geo": "Point(4.58838 46.112739)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22829617",
		"itemLabel": "château d'Auray",
		"geo": "Point(-2.980278 47.66625)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22893354",
		"itemLabel": "Q22893354",
		"geo": "Point(2.742913888 42.549272222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22919868",
		"itemLabel": "château fort de Molières",
		"geo": "Point(0.825361 44.811444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22920606",
		"itemLabel": "château d'Aphat",
		"geo": "Point(-1.176063 43.162031)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22920628",
		"itemLabel": "château des barons d'Espelette",
		"geo": "Point(-1.445898 43.340202)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22920842",
		"itemLabel": "château de Saint-Pée-sur-Nivelle",
		"geo": "Point(-1.548707 43.353394)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22920865",
		"itemLabel": "château d'Haïtze",
		"geo": "Point(-1.461817 43.396521)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22932528",
		"itemLabel": "prieuré-château de Saint-Arcons-d'Allier",
		"geo": "Point(3.550175 45.068501)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22952693",
		"itemLabel": "Vieux-Deffend",
		"geo": "Point(-0.754811 46.844219)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22963554",
		"itemLabel": "manoir de la Sausserie",
		"geo": "Point(-0.714192 48.597011)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22965934",
		"itemLabel": "château des Épaux",
		"geo": "Point(4.596705 46.521516)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22986652",
		"itemLabel": "castelas d'Uchaux",
		"geo": "Point(4.80288 44.21111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22992328",
		"itemLabel": "château fort de la Faye",
		"geo": "Point(3.651672 45.73919)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q22997598",
		"itemLabel": "château d'Uhart-Mixe",
		"geo": "Point(-1.019172 43.279314)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q23687064",
		"itemLabel": "abbaye de Jully-les-Nonnains",
		"geo": "Point(4.2782 47.7859)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q23687064",
		"itemLabel": "abbaye de Jully-les-Nonnains",
		"geo": "Point(4.2967 47.7756)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q23895151",
		"itemLabel": "château de Haneck",
		"geo": "Point(7.212222222 48.023611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968578",
		"itemLabel": "château de Bois-le-Roi",
		"geo": "Point(3.21917 48.2194)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968580",
		"itemLabel": "château de Bois-lès-Pargny",
		"geo": "Point(3.6487 49.7321)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968581",
		"itemLabel": "château de Bois Chevalier",
		"geo": "Point(-1.57097 46.912)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968583",
		"itemLabel": "château de Boisgibault",
		"geo": "Point(1.8666 47.7882)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968586",
		"itemLabel": "château de Boissy-le-Sec",
		"geo": "Point(2.089677 48.477088)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968587",
		"itemLabel": "château de Bon Repos",
		"geo": "Point(5.75639 45.1103)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968589",
		"itemLabel": "château de Bonnay",
		"geo": "Point(6.0507 47.3356)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968592",
		"itemLabel": "château de Bonnelles",
		"geo": "Point(2.02278 48.6203)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968593",
		"itemLabel": "château de Bonnemare",
		"geo": "Point(1.333 49.3317)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968595",
		"itemLabel": "château de Bonnes",
		"geo": "Point(0.15028 45.2397)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968596",
		"itemLabel": "château de Bonneville",
		"geo": "Point(6.40822 46.079)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968598",
		"itemLabel": "château de Bonneville-sur-Touques",
		"geo": "Point(0.1175 49.3375)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968600",
		"itemLabel": "château de Bonnivet",
		"geo": "Point(0.335 46.7261)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968603",
		"itemLabel": "château de Bontin",
		"geo": "Point(3.24633 47.8473)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968604",
		"itemLabel": "château de Bord-Peschin",
		"geo": "Point(2.76014 46.3358)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968607",
		"itemLabel": "château de Bossancourt",
		"geo": "Point(4.60059 48.2824)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968611",
		"itemLabel": "château de Bostfranchet",
		"geo": "Point(3.90361111 45.46944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968612",
		"itemLabel": "château de Boucherolles",
		"geo": "Point(3.18181 46.4009)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968614",
		"itemLabel": "château de Bouillac",
		"geo": "Point(2.1614 44.5758)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968615",
		"itemLabel": "château de Bouilhonnac",
		"geo": "Point(2.44018 43.2323)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968616",
		"itemLabel": "château de Bouillé-Théval",
		"geo": "Point(-0.781687 47.744)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2968619",
		"itemLabel": "château de Bouligneux",
		"geo": "Point(4.99125 46.0242)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971573",
		"itemLabel": "château des comtes de Bryas",
		"geo": "Point(4.70389 49.9936)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971921",
		"itemLabel": "châteaux d'Oberhof",
		"geo": "Point(7.3642 48.7415)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2971923",
		"itemLabel": "châteaux des princes de Salm-Salm",
		"geo": "Point(6.98306 48.3956)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q2975684",
		"itemLabel": "Clarus Mons",
		"geo": "Point(3.08637 45.7805)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3036702",
		"itemLabel": "donjon Lacataye",
		"geo": "Point(-0.49888889 43.89222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3036723",
		"itemLabel": "donjon de Marthon",
		"geo": "Point(0.445555555 45.6125)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3036734",
		"itemLabel": "donjon de Montignac-Charente",
		"geo": "Point(0.123888888 45.784444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3077955",
		"itemLabel": "fort Médoc",
		"geo": "Point(-0.70222222 45.11138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3077976",
		"itemLabel": "fort Paté",
		"geo": "Point(-0.678611111 45.117777777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3078019",
		"itemLabel": "fort Saint-André",
		"geo": "Point(4.801436 43.96657)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3078149",
		"itemLabel": "fort de Bois l'Abbé",
		"geo": "Point(6.40046 48.20442)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3078423",
		"itemLabel": "forteresse de Largoët",
		"geo": "Point(-2.618611111 47.725277777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3146182",
		"itemLabel": "hôtel de ville de Saint-Côme-d'Olt",
		"geo": "Point(2.81472222 44.51527778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3280193",
		"itemLabel": "maison forte de Reignac",
		"geo": "Point(1.05527778 44.97944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3286199",
		"itemLabel": "manoir de Grézignac",
		"geo": "Point(0.86861111 45.23222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3286205",
		"itemLabel": "manoir de Jaillac",
		"geo": "Point(0.81972222 45.28638889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3286249",
		"itemLabel": "manoir de Mitonias",
		"geo": "Point(0.4025 45.405)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3286313",
		"itemLabel": "manoir de la Borie-Fricart",
		"geo": "Point(0.69416667 45.32194444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3286369",
		"itemLabel": "manoir de la Vermondie",
		"geo": "Point(1.09527778 45.02944444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3286388",
		"itemLabel": "manoir des Pautis",
		"geo": "Point(0.82944444 45.30388889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3286396",
		"itemLabel": "manoir du Chatenet",
		"geo": "Point(0.64666667 45.35638889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3325349",
		"itemLabel": "Motte Saint-Albe"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3407309",
		"itemLabel": "Projets architecturaux de Catherine de Médicis"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3533155",
		"itemLabel": "tour Philippe-le-Bel",
		"geo": "Point(4.79753 43.9586)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3533430",
		"itemLabel": "tour de Ratières",
		"geo": "Point(4.97278 45.1853)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3533460",
		"itemLabel": "tour de Termes-d'Armagnac",
		"geo": "Point(-0.012777777 43.671388888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q3535527",
		"itemLabel": "tours de Merle",
		"geo": "Point(2.074722222 45.064166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118844",
		"itemLabel": "château de Saint-Sulpice",
		"geo": "Point(1.787585 44.570048)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118845",
		"itemLabel": "château de Saint-Thamar",
		"geo": "Point(1.979856 44.78894)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118846",
		"itemLabel": "château de Saint-Élix-Séglan",
		"geo": "Point(0.85222222 43.195)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118848",
		"itemLabel": "château de Sarremezan",
		"geo": "Point(0.665 43.20833333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118850",
		"itemLabel": "château de Sigy",
		"geo": "Point(3.17361111 48.48027778)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118852",
		"itemLabel": "château de Sévérac",
		"geo": "Point(3.06861111 44.32305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118856",
		"itemLabel": "château de Vallègue",
		"geo": "Point(1.75444444 43.42444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118857",
		"itemLabel": "château de Vaulogé",
		"geo": "Point(-0.04944444 47.89222222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118858",
		"itemLabel": "château de Vernègues",
		"geo": "Point(5.1674 43.6902)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118859",
		"itemLabel": "château de Vieillevigne",
		"geo": "Point(1.65722222 43.40444444)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118860",
		"itemLabel": "château de Villefranche",
		"geo": "Point(1.41527778 43.76972222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118863",
		"itemLabel": "château de Wildenstein",
		"geo": "Point(6.95916667 47.94916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118864",
		"itemLabel": "Q5118864",
		"geo": "Point(5.44222222 45.22680556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118869",
		"itemLabel": "Q5118869",
		"geo": "Point(-0.13833333 48.68555556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118870",
		"itemLabel": "château de la Pannonie",
		"geo": "Point(1.653689 44.777303)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118874",
		"itemLabel": "château des Junies",
		"geo": "Point(1.23611111 44.53916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118877",
		"itemLabel": "château de Rohan",
		"geo": "Point(7.45361111 48.53638889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118879",
		"itemLabel": "château du Houssoy",
		"geo": "Point(3.06388889 49.09138889)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118881",
		"itemLabel": "château du Théron",
		"geo": "Point(1.17241 44.521345)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118883",
		"itemLabel": "château fort de Puyravaux"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5118890",
		"itemLabel": "Q5118890"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5122393",
		"itemLabel": "Q5122393",
		"geo": "Point(8.74027778 41.91666667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5296211",
		"itemLabel": "donjon de Maurepas",
		"geo": "Point(1.92063889 48.77261111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q5472467",
		"itemLabel": "Q5472467",
		"geo": "Point(3.3599 43.4268)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18292640",
		"itemLabel": "château de Lamothe",
		"geo": "Point(3.424723 45.313348)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18413974",
		"itemLabel": "château de Montcoquier",
		"geo": "Point(3.27611 46.38333)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18520681",
		"itemLabel": "château de Gourdans",
		"geo": "Point(5.2272 45.8293)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q18524007",
		"itemLabel": "château Marcel",
		"geo": "Point(5.2189 45.8281)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q7837485",
		"itemLabel": "Q7837485",
		"geo": "Point(-2.5922 47.7933)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q11913000",
		"itemLabel": "château d'Espira-de-Conflent",
		"geo": "Point(2.500019444 42.62355)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q11913022",
		"itemLabel": "château de Sansa",
		"geo": "Point(2.17361111 42.60305556)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q11913072",
		"itemLabel": "château de Paracolls de Conflent",
		"geo": "Point(2.38222222 42.64666667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q11913082",
		"itemLabel": "château de Querroig",
		"geo": "Point(3.120833333 42.438055555)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q11913085",
		"itemLabel": "château de Riell",
		"geo": "Point(2.38694444 42.64722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q11913088",
		"itemLabel": "château de Rodès",
		"geo": "Point(2.56333333 42.65916667)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q11913969",
		"itemLabel": "Citadelle de Mont-Louis",
		"geo": "Point(2.11861 42.5103)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q11930960",
		"itemLabel": "Q11930960",
		"geo": "Point(2.35722222 42.5675)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q12252886",
		"itemLabel": "Q12252886",
		"geo": "Point(-1.162427 43.15159583)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q12257359",
		"itemLabel": "château d'Etchaux",
		"geo": "Point(-1.34569 43.1774)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q12258150",
		"itemLabel": "château de Camou",
		"geo": "Point(-1.019128 43.36493983)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q12258858",
		"itemLabel": "Q12258858",
		"geo": "Point(-1.46666667 43.40861111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q12261813",
		"itemLabel": "château de Lacarre",
		"geo": "Point(-1.16395083 43.192284)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q12261996",
		"itemLabel": "Q12261996",
		"geo": "Point(-1.08279783 43.25281183)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q12262614",
		"itemLabel": "Q12262614",
		"geo": "Point(-1.455 43.39722222)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q12266656",
		"itemLabel": "Q12266656",
		"geo": "Point(-1.14701483 43.193739)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q12266657",
		"itemLabel": "Q12266657",
		"geo": "Point(-1.20761183 43.353141)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q24764042",
		"itemLabel": "château de Gray",
		"geo": "Point(5.59287 47.44636)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q24940571",
		"itemLabel": "château de Gaillard"
	},
	{
		"item": "http://www.wikidata.org/entity/Q25432259",
		"itemLabel": "Château de Vivès",
		"geo": "Point(2.763522222 42.528852777)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q25927149",
		"itemLabel": "château du Vuache"
	},
	{
		"item": "http://www.wikidata.org/entity/Q27603065",
		"itemLabel": "ancien château des comtes de Champagne",
		"geo": "Point(4.076668 48.301466)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q27921838",
		"itemLabel": "château Lapalus",
		"geo": "Point(4.825322 46.34268)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q28001405",
		"itemLabel": "château Saint-Clair",
		"geo": "Point(-1.795555555 46.493888888)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q28024947",
		"itemLabel": "château de la Tour",
		"geo": "Point(1.919166666 50.303611111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q43892062",
		"itemLabel": "château de Baillestavy",
		"geo": "Point(2.524422222 42.564511111)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q44747591",
		"itemLabel": "château de Bussy",
		"geo": "Point(2.623611111 46.904166666)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q30321661",
		"itemLabel": "château de l'Étang"
	},
	{
		"item": "http://www.wikidata.org/entity/Q30339114",
		"itemLabel": "Château de Rochegude (Saint-Privat-d'Allier)",
		"geo": "Point(3.647012 44.985886)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q32998722",
		"itemLabel": "château de Dommerville",
		"geo": "Point(1.98928 48.3186)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q38251110",
		"itemLabel": "château de Drée",
		"geo": "Point(4.3084 46.3207)"
	},
	{
		"item": "http://www.wikidata.org/entity/Q38251110",
		"itemLabel": "château de Drée",
		"geo": "Point(4.30873 46.3208)"
	}];
  
  	var goldStar = {
      path: 'M 0,0 0,10 10,10 10,0 z',
      fillColor: 'red',
      fillOpacity: 1,
      scale: 1,
      strokeColor: 'red',
      strokeWeight: 1
    };
  
    data.forEach(function(datum) {
    	if(datum.geo) {
	    	latlon=datum.geo.match(/^Point\((.*) (.*)\)$/);
	        createMarker({
	            position: new google.maps.LatLng(latlon[2], latlon[1]),
	            map: map,
	            icon: goldStar
	        }, datum.itemLabel);
    	}
    });

});