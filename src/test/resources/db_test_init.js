var conn = new Mongo();
var db = conn.getDB("sptransp_test");

// ==== Sequences ====

// Collection counters used as sequences
// https://docs.mongodb.org/manual/tutorial/create-an-auto-incrementing-field/

db.counters.drop();
db.createCollection("counters");

db.counters.insert(
    {
        _id: "requestId",
        seq: 0
    }
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

db.departments.insert({code: "Law compliance", name: "LAW_COMPLIANCE"});
db.departments.insert({code: "Shuttle compliance", name: "SHUTTLE_COMPLIANCE"});
db.departments.insert({code: "Goods inspection", name: "GOODS_INSPECTION"});
db.departments.insert({code: "Journey supervision", name: "JOURNEY_SUPERVISION"});
db.departments.insert({code: "Human resources", name: "HR"});

// ==== Destinations ====

db.destinations.drop();
db.createCollection("destinations");

db.destinations.insert({code: "EARTH", name: "Earth", destination_comment: "Solar system planet"});
db.destinations.insert({code: "MOON", name: "Moon", destination_comment: "Earth's satellite"});
db.destinations.insert({code: "MARS", name: "Mars", destination_comment: "Solar system planet"});
db.destinations.insert({code: "MARS_PHOBOS", name: "Phobos", destination_comment: "Mar's satellite"});
db.destinations.insert({code: "MARS_DEIMOS", name: "Deimos", destination_comment: "Mar's satellite"});
db.destinations.insert({code: "JUPITER_IO", name: "Io", destination_comment: "Jupiter's satellite"});
db.destinations.insert({code: "JUPITER_EUROPA", name: "Europa", destination_comment: "Jupiter's satellite"});
db.destinations.insert({code: "JUPITER_GANYMEDE", name: "Ganymede", destination_comment: "Jupiter's satellite"});
db.destinations.insert({code: "JUPITER_CALLISTO", name: "Callisto", destination_comment: "Jupiter's satellite"});
db.destinations.insert({code: "SATURN_TITAN", name: "Titan", destination_comment: "Jupiter's satellite"});
db.destinations.insert({code: "SATURN_RHEA", name: "Rhea", destination_comment: "Saturn's satellite"});
db.destinations.insert({code: "SATURN_DIONE", name: "Dione", destination_comment: "Saturn's satellite"});
db.destinations.insert({code: "SATURN_TETHYS", name: "Tethys", destination_comment: "Saturn's satellite"});
db.destinations.insert({code: "SATURN_MIMAS", name: "Mimas", destination_comment: "Saturn's satellite"});
db.destinations.insert({code: "SATURN_ENCELADUS", name: "Enceladus", destination_comment: "Saturn's satellite"});

