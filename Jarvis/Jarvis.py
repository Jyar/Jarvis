from gtts import gTTS
import speech_recognition as sr
import os
import webbrowser
import smtplib


def talkToMe(audio):
    print(audio)
    tts = gTTS(text=audio, lang='en')
    tts.save('audio.mp3')
    os.system('mpg123 audio.mp3')

#listens for commands

def myCommand():
    r = sr.Recognizer()
    with sr.Microphone() as source:
        print('I am ready for your next command')
        r.pause_threshold = 1
        r.adjust_for_ambient_noise(source, duration= 1)
        audio = r.listen(source)
    try:
        command = r.recognize_google(audio)
        print('You said ' + command + '/n')
    #loop back to continue
    except sr.UnkownValueError:
        assistant(myCommand())
    return command


def assistant(command):
    if 'Open Reddit python' in command:
        chrome_path = '/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --enable-speech-input www.google.com'
        url = 'https://www.reddit.com/r/python'
        webbrowser.get(chrome_path).open(url)
    if 'what\'s up' in command:
        talkToMe('Contemplating my existence')
    if 'hi' in command:
        talkToMe('Hello')
    if 'email' in command:
        talkToMe('Who is the recipient')
        recipient = myCommand()

        #if 'Jordan' in recipient:
            #talkToMe('What should I say')
            #content = myCommand()

            #init gmail smtp

            #mail = smtplib.SMTP('smtp.gmail.com', 587)

            #identify to server
            #mail.ehlo()

            #encrypt
            #mail.starttls()
            #

talkToMe('Ready for your next command')

while True:
    assistant(myCommand())