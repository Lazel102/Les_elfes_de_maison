# Documentation

## Todo
- Implement a notification in "home.html" : "You haven't registered in any event yet, you can join or create a new event below".
- Implement a link toward a Registered event without the "Join Event" button in "event.html" (Fresh Event # Registered event).
- In "event.html" Update the multiple recipe image containers.
- In "event.html" Implement the event's description under its title.
- In "addRecipe.html" and "createEvent.html" CHECK THE PROPER IMPLEMENTATION  of image upload (check push history "Updated IMAGE UPLOAD ??" june 1)
- In "event.html" and "createEvent" implement button to send to "addRecipe.html".
- Push gradle.bat.
- Create MySettings.html (homepage).
- Include commentary section for each page.
- Include description for recipes.

## BUG FIXES
- In "joinEvent" Check the implementation of submit button: is it necessary to have "th:action="@{{eventId}/joinEvent(eventId=${event.id})}" and "th:onclick="|window.location.href='@{/createRecipe}'| "
- Input type="number" can still be filled with "e" letters.
- Set a maximum character number for {event.title}, {recipes}, {numberOfParticipants}, {kitchenAdress}.
- Regarding Backend's developement: What was the reason why we can't use "href=" to link a <button> or <a> for compatibility with thymeLeaf?
- What is the purpose of "th:remove="all-but-first" in joinEvent.html ?
- How to generate a new class='eventContainer' in joinevent.html every time a user creates one ?

## Notes
- In the ressources folder in future updates is a folder with possible future templates.

## Design
- Check consistency on different pages.
- Set proper gaps, margins and spacings.
- Differenciate Fresh Events from Registered Events.
- Rethink colors (add saturation, gradients/sketchy edges...)
- Find new open font.
 
## Expantion Ideas
- Recipes can later be added to userprofil.
- The users within an event will in the future be able to vote for a date.
- Previous events can later be displayed in each user's profile
- User can later access a calendar with its upcoming events
- Notifications to remind upcoming events and archive previous ones

## Glossar
- **Event**: A batch cooking event
- **Fresh event**: A batch cooking event that is still open in joinEvent.html
- **Registered event**: When a given user is currently enrolled in a specific batch cooking event
- **Locked event**: A batch cooking event that is confirmed and that is nor open nor available open in joinEvent.html

