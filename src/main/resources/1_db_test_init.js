var conn = new Mongo();
var db = conn.getDB("sptransp_test");

db.agreementRules.drop();
db.createCollection("agreementRules");
db.requests.drop();
db.createCollection("requests");

// ==== Sequences ====

// Collection counters used as sequences
// https://docs.mongodb.org/manual/tutorial/create-an-auto-incrementing-field/

db.counters.drop();
db.createCollection("counters");

db.counters.insert(
    {_id: "requestId", seq: 0},
    {_id: "userId", seq: 50}
);

// ==== Goods ====

db.goods.drop();
db.createCollection("goods");

db.goods.insert({code: "OIL", name: "Oil"});
db.goods.insert({code: "FOOD", name: "Food"});
db.goods.insert({code: "MACHINE_TOOL", name: "Machine tool"});
db.goods.insert({code: "MEDICINE", name: "Medicine"});
db.goods.insert({code: "WEAPON", name: "Weapon"});

// ==== Departments ====

db.departments.drop();
db.createCollection("departments");

db.departments.insert({code: "LAW_COMPLIANCE", name: "Law compliance"});
db.departments.insert({code: "SHUTTLE_COMPLIANCE", name: "Shuttle compliance"});
db.departments.insert({code: "GOODS_INSPECTION", name: "Goods inspection"});
db.departments.insert({code: "JOURNEY_SUPERVISION", name: "Journey supervision"});
db.departments.insert({code: "HR", name: "Human resources"});

// ==== Destinations ====

db.destinations.drop();
db.createCollection("destinations");

db.destinations.insert({code: "EARTH", name: "Earth", comment: "Solar system planet"});
db.destinations.insert({code: "MOON", name: "Moon", comment: "Earth's satellite"});
db.destinations.insert({code: "MARS", name: "Mars", comment: "Solar system planet"});
db.destinations.insert({code: "MARS_PHOBOS", name: "Phobos", comment: "Mar's satellite"});
db.destinations.insert({code: "MARS_DEIMOS", name: "Deimos", comment: "Mar's satellite"});
db.destinations.insert({code: "JUPITER_IO", name: "Io", comment: "Jupiter's satellite"});
db.destinations.insert({code: "JUPITER_EUROPA", name: "Europa", comment: "Jupiter's satellite"});
db.destinations.insert({code: "JUPITER_GANYMEDE", name: "Ganymede", comment: "Jupiter's satellite"});
db.destinations.insert({code: "JUPITER_CALLISTO", name: "Callisto", comment: "Jupiter's satellite"});
db.destinations.insert({code: "SATURN_TITAN", name: "Titan", comment: "Jupiter's satellite"});
db.destinations.insert({code: "SATURN_RHEA", name: "Rhea", comment: "Saturn's satellite"});
db.destinations.insert({code: "SATURN_DIONE", name: "Dione", comment: "Saturn's satellite"});
db.destinations.insert({code: "SATURN_TETHYS", name: "Tethys", comment: "Saturn's satellite"});
db.destinations.insert({code: "SATURN_MIMAS", name: "Mimas", comment: "Saturn's satellite"});
db.destinations.insert({code: "SATURN_ENCELADUS", name: "Enceladus", comment: "Saturn's satellite"});

