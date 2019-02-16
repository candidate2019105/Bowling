<h1>Readme</h1>

<p> Assuming that you already have Gradle installed on your computer.</p>
 
<h2> Compile and Run</h2>
<p> 
 use `./gradle build
 <br/>
 then use 
 <ul>
  <li>
   'x' for strikes
  </li>  
  <li>
   '-' for spares (be care of having number on first roll)
  </li>  
  <li>
   '0..9' number for classic roll
  </li>  
 </ul>
 <br/>
 As follow : 
 
 <ul>
 <li>
   `./gradle run --args="x x x x x x x x x x x x"` => for perfect game
 </li>
 <li> 
  `./gradle run --args="5 - 5 - 5 - 5 - 5 - 5 - 5 - 5 - 5 - 5 - 5"` => for full of spare game
 </li>
 <li>
  `./gradle run --args="1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1"` => just for fun
 </li>
 <li> 
  `./gradle run --args="1 2 3 4 5 - 6 3 7 2 8 1 0 0 0 0 0 0 0 0 0"
 </li>
 </ul>
</p>
