import axios from "axios";

export default axios.create({
    baseURL: "https://anon-notes-backend.herokuapp.com/api",
    headers: {
        "Content-type": "application/json"
    }
})