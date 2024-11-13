from flask import Flask, jsonify, request

app = Flask(__name__)

# Contoh data untuk testing
data = [
    {"name": "ItemA", "address": "AddressA"},
    {"name": "ItemB", "address": "AddressB"},
    {"name": "ItemC", "address": "AddressC"}
]


# Endpoint untuk GET all data
@app.route('/getall', methods=['GET'])
def get_all():
    return jsonify(data)

# Endpoint untuk GET by name
@app.route('/getbyname/<name>', methods=['GET'])
def get_by_name(name):
    result = [item for item in data if item["name"] == name]
    return jsonify(result)

# Endpoint untuk GET by address
@app.route('/getbyaddress/<address>', methods=['GET'])
def get_by_address(address):
    result = [item for item in data if item["address"] == address]
    return jsonify(result)

# Endpoint untuk POST data baru
@app.route('/add', methods=['POST'])
def add_data():
    new_item = request.json
    data.append(new_item)
    return jsonify({"message": "Data added successfully!"}), 201

if __name__ == '__main__':
    app.run(host='127.0.0.1', port=5000)

