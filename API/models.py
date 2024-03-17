from django.db import models
from django.utils import timezone


class User(models.Model):
    id = models.AutoField(primary_key=True)
    full_name = models.TextField(max_length=30, null=False, blank=False)
    login =  models.TextField(max_length=30, null=False, blank=False)
    password =  models.TextField(max_length=30, null=False, blank=False)

class Event(models.Model):
    id = models.AutoField(primary_key=True)
    name = models.TextField(max_length=30, null=False, blank=False)
    start_time = models.DateTimeField(default=timezone.now)
    end_time = models.DateTimeField(default=timezone.now)
    type = models.TextField(max_length=15, null=True)
    link = models.TextField(max_length=50, null=True)
    address = models.TextField(max_length=50, null=True)
    description = models.TextField(max_length=100)

class UserEvent(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    event = models.ForeignKey(Event, on_delete=models.CASCADE)