import os
from flask import Flask
from pymongo import MongoClient

app = Flask(__name__)
# Updated default to 9096
port = int(os.environ.get("FLASK_SERVER_PORT", 9096))

client = MongoClient("mongodb://mongo:27017/")
db = client.test_db

@app.route('/')
def index():
    db.hits.insert_one({"event": "page_load"})
    count = db.hits.count_documents({})
    return f"Backend is now running on port {port}. Database entries: {count}"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=port)