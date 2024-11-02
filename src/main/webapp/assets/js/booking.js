const today = new Date().toISOString().split('T')[0];
document.getElementById('startDate').min = today;
document.getElementById('endDate').min = today;

function selectRoomType(roomTypeId) {
    document.querySelectorAll('.room-type-card').forEach(card => {
        card.classList.remove('selected');
    });
    const selectedCard = document.querySelector(`[value="${roomTypeId}"]`).closest('.room-type-card');
    selectedCard.classList.add('selected');
}

document.getElementById('endDate').addEventListener('change', function() {
    const startDate = new Date(document.getElementById('startDate').value);
    const endDate = new Date(this.value);
    
    if (endDate < startDate) {
        alert('Check-out date cannot be earlier than check-in date');
        this.value = document.getElementById('startDate').value;
    }
});

document.getElementById('bookingForm').addEventListener('submit', function(e) {
    const pet = document.getElementById('pet').value;
    const roomType = document.querySelector('input[name="roomTypeId"]:checked');
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;
    const startTime = document.getElementById('startTime').value;
    const endTime = document.getElementById('endTime').value;

    if (!pet || !roomType || !startDate || !endDate || !startTime || !endTime) {
        e.preventDefault();
        alert('Please fill in all required fields');
    }
});