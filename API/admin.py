from django.contrib import admin
from API.models import User, Event, UserEvent


# Register your models here.
admin.site.register(User)
admin.site.register(Event)
admin.site.register(UserEvent)