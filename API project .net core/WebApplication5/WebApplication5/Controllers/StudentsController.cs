using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using WebApplication5.Model;

namespace WebApplication5.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentsController : ControllerBase
    {
        private readonly StudentDbContext _context;
        public StudentsController(StudentDbContext context)
        {
            _context = context;
        }
        [HttpPost]
        public Student GetStudents(Student student)
        {

            _context.Students.Add(student);
            _context.SaveChanges();

            return student;
        }
        [HttpGet]
        public List<Student> GetStudents()
        {
            return _context.Students.ToList();
        }


        [HttpGet("{id:int}")]
        public object GetStudent(int id)
        {
            var student = _context.Students.FirstOrDefault(x=>x.StudentId==id);
            if (student == null)
                return new { StatusCode=404,Message="Record not found" };

            return student;
        }
        [HttpDelete("{id:int}")]
        public object DeleteStudent(int id)
        {
            var student = _context.Students.FirstOrDefault(x => x.StudentId == id);
            if (student == null)
                return new { StatusCode = 404, Message = "Record not found" };

            _context.Students.Remove(student);
            _context.SaveChanges();
            return  new { StatusCode = 202, Message = $"Record deleted of id {id}" };
        }
    }
}
