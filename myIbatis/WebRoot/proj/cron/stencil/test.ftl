      <div>
        <h2>�ʾ��б�<span>����flt</span></h2>
        <ul>
       		<#list indaList as inda>
			<li>��<a href=""   title="${inda.inda_id}"  target="_blank" >
			<#if inda.inda_title?length lt 17>${inda.inda_title}<#else>${inda.inda_title[0..16]}</#if></a></li>
			</#list>		  
        </ul>
      </div>