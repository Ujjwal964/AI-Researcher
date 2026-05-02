document.addEventListener("DOMContentLoaded", () => {
    const preSavedNotes = localStorage.getItem("notes");
    if (preSavedNotes) {
        document.getElementById("notes").value = preSavedNotes;
        console.log("Fetched pre saved notes. \n" + JSON.stringify(localStorage));
    }

    document.getElementById("suggest").addEventListener("click", () => {
        console.log("Suggest Button Clicked.");
        suggestText();
    });

    document.getElementById("summarize").addEventListener("click", () => {
        console.log("Summarize Button Clicked.");
        summarizeText();
    });

    document.getElementById("copyNotes").addEventListener("click", () => {
        console.log("Copy Icon Clicked.");
        copyNotes();
    });

    document.getElementById("save").addEventListener("click", () => {
        console.log("Save Button Clicked.");
        const notes = document.getElementById("notes").value;
        localStorage.setItem("notes", notes);
        alert("Notes saved.")
        console.log("Notes Saved");
    });
});

//HELPER METHODS
async function summarizeText() {
    try {
        const [tab] = await chrome.tabs.query({ active: true, currentWindow: true }); //get current active tab.(CHROME DEFAULT BUILT IN COMMAND)
        const [{ result }] = await chrome.scripting.executeScript({
            target: { tabId: tab.id },
            func: () => window.getSelection().toString()
        });                                                                           //getting user selected text.(CHROME DEFAULT BUILT IN COMMAND) Using [] bcos returns back array.

        if (!result) {
            showResults("Please select some text first.");
            return;
        }

        showLoadingState();
        console.log("User Selected Text : " + result);
        const response = await fetch("http://localhost:8080/research/content", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ content: result, operation: "summarize" })
        });

        if (!response.ok)
            throw new Error(`API Error : ${response.status} , ${response.statusText}`);

        const summarizeFinalAnswer = await response.text();
        showResults(summarizeFinalAnswer);

    } catch (error) {
        console.error("Error occured : " + error);
        showResults("Something went wrong!");
    }
}

async function suggestText() {
    try {
        const [tab] = await chrome.tabs.query({ active: true, currentWindow: true });
        const [{ result }] = await chrome.scripting.executeScript({
            target: { tabId: tab.id },
            func: () => window.getSelection().toString()
        });

        if (!result) {
            showResults("Please select some text first.");
            return;
        }

        showLoadingState();
        console.log("User selected text : " + result);
        const response = await fetch("http://localhost:8080/research/content", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ content: result, operation: "suggest" })
        });

        if (!response.ok)
            throw new Error(`API Error : ${response.status} , ${response.statusText}`);

        const suggestFinalAnswer = await response.text();
        showResults(suggestFinalAnswer);

    } catch (error) {
        console.log("Error occured : " + error);
        showResults("Something went wrong!");
    }
}

async function copyNotes() {
    const text = document.getElementById("notes").value;
    if (!text) {
        alert("Noting to copy!");
        return;
    }
    await navigator.clipboard.writeText(text);
    alert("Copied to Clipboard.");
}

function showResults(response) {
    let ans = response .replace(/#+\s*/g, "") .replace(/\*\*/g, "") .replace(/\*/g, "") .replace(/`+/g, "") .replace(/\n{2,}/g, "\n\n");
    document.getElementById("results").innerText = ans;
}

function showLoadingState(){
    document.getElementById("results").innerText = "Analyzing...";
}

