function setMinDates() {
    const startDate = document.getElementById('startDate');
    const endDate = document.getElementById('endDate');

    const today = new Date();
    today.setDate(today.getDate() + 1);

    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, '0');
    const day = String(today.getDate()).padStart(2, '0');

    const minDate = `${year}-${month}-${day}`;

    startDate.setAttribute('min', minDate);
    endDate.setAttribute('min', minDate);

    endDate.disabled = true;
    document.getElementById('endTime').disabled = true;
}

function populateTimeOptions(selectId) {
    const select = document.getElementById(selectId);
    const startHour = 9;
    const endHour = 19;

    for (let hour = startHour; hour <= endHour; hour++) {
        const time = hour.toString().padStart(2, '0') + ":00";
        const option = document.createElement('option');
        option.value = time;
        option.textContent = time;
        select.appendChild(option);
    }
}

function updateEndDateMin() {
    const startDate = document.getElementById('startDate');
    const endDate = document.getElementById('endDate');

    const minEndDate = new Date(startDate.value);
    minEndDate.setDate(minEndDate.getDate() + 1);
    
    const year = minEndDate.getFullYear();
    const month = String(minEndDate.getMonth() + 1).padStart(2, '0');
    const day = String(minEndDate.getDate()).padStart(2, '0');
    
    endDate.min = `${year}-${month}-${day}`;
    if (new Date(endDate.value) <= new Date(startDate.value)) {
        endDate.value = `${year}-${month}-${day}`;
    }
}

function enableEndDateTime() {
    const startDate = document.getElementById('startDate');
    const startTime = document.getElementById('startTime');
    const endDate = document.getElementById('endDate');
    const endTime = document.getElementById('endTime');

    if (startDate.value && startTime.value) {
        endDate.disabled = false;
        endTime.disabled = false;
        updateEndDateMin();
    } else {
        endDate.disabled = true;
        endTime.disabled = true;
    }
}

function updateEndTimeMin() {
    const endTime = document.getElementById('endTime');
    for (let i = 0; i < endTime.options.length; i++) {
        endTime.options[i].disabled = false;
    }
}

window.onload = function() {
    setMinDates();
    populateTimeOptions('startTime');
    populateTimeOptions('endTime');

    document.getElementById('startDate').addEventListener('change', enableEndDateTime);
    document.getElementById('startTime').addEventListener('change', enableEndDateTime);
    document.getElementById('endDate').addEventListener('change', updateEndTimeMin);
};