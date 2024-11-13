import requests

# Ganti IP_Device_A dengan alamat IP dari Device A
base_url = "http://127.0.0.1:5000"


# Function untuk melakukan GET all
def get_all():
    response = requests.get(f"{base_url}/getall")
    return response.json()

# Function untuk melakukan GET by name
def get_by_name(name):
    response = requests.get(f"{base_url}/getbyname/{name}")
    return response.json()

# Function untuk melakukan GET by address
def get_by_address(address):
    response = requests.get(f"{base_url}/getbyaddress/{address}")
    return response.json()

# Function untuk melakukan POST data baru
def add_data(name, address):
    new_data = {"name": name, "address": address}
    response = requests.post(f"{base_url}/add", json=new_data)
    return response.json()

# Contoh penggunaan fungsi
if __name__ == "__main__":
    print("GET All Data:", get_all())
    print("GET by Name (Item1):", get_by_name("Item1"))
    print("GET by Address (Address2):", get_by_address("Address2"))
    print("POST New Data:", add_data("Item3", "Address3"))
