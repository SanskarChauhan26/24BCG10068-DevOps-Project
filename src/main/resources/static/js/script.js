const API_URL = "http://localhost:8081/events";
let editingId = null;

// Load events when page loads
window.onload = function () {
    loadEvents();
};

// ----------------------
// Add or Update Event
// ----------------------
async function addEvent() {
    const event = {
        date: document.getElementById("date").value,
        eventName: document.getElementById("eventName").value,
        description: document.getElementById("description").value,
        footFall: document.getElementById("footFall").value,
        guest: document.getElementById("guest").value,
        fees: document.getElementById("fees").value
    };

    let response;

    if (editingId == null) {
        // ADD EVENT
        response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(event)
        });
    } else {
        // UPDATE EVENT
        response = await fetch(API_URL + "/" + editingId, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(event)
        });
        editingId = null;
        document.getElementById("addButton").innerHTML = "Add Event";
    }

    alert(await response.text());
    clearForm();
    loadEvents();
}

// ----------------------
// Load Events
// ----------------------
async function loadEvents() {
    const response = await fetch(API_URL);
    const events = await response.json();

    let rows = "";
    events.forEach(event => {
        rows += `
        <tr>
            <td>${event.id}</td>
            <td>${event.eventName}</td>
            <td>${event.description}</td>
            <td>
                <span class="badge bg-danger">
                    ${event.footFall}
                </span>
            </td>
            <td>
                <span class="badge bg-warning">
                    ${event.guest}
                </span>
            </td>
            <td>${event.date}</td>
            <td>${event.fees}</td>
            <td>
                <button
                    class="btn btn-primary btn-sm"
                    onclick="editEvent(${event.id})">
                    Edit
                </button>
                <button
                    class="btn btn-danger btn-sm"
                    onclick="deleteEvent(${event.id})">
                    Delete
                </button>
            </td>
        </tr>
        `;
    });

    document.getElementById("eventTable").innerHTML = rows;
}

// ----------------------
// Edit Event
// ----------------------
async function editEvent(id) {
    const response = await fetch(API_URL);
    const events = await response.json();
    const event = events.find(e => e.id === id);
    if (!event) return;

    document.getElementById("eventName").value = event.eventName;
    document.getElementById("description").value = event.description;
    document.getElementById("footFall").value = event.footFall;
    document.getElementById("guest").value = event.guest;
    document.getElementById("date").value = event.date;
    document.getElementById("fees").value = event.fees;

    editingId = id;
    document.getElementById("addButton").innerHTML = "Update Event";
}

// ----------------------
// Delete Event
// ----------------------
async function deleteEvent(id) {
    if (!confirm("Delete this event?")) {
        return;
    }

    await fetch(API_URL + "/" + id, {
        method: "DELETE"
    });

    loadEvents();
}

// ----------------------
// Clear Form
// ----------------------
function clearForm() {
    document.getElementById("eventName").value = "";
    document.getElementById("description").value = "";
    document.getElementById("footFall").value = "";
    document.getElementById("guest").value = "";
    document.getElementById("date").value = "";
    document.getElementById("fees").value = "";
}